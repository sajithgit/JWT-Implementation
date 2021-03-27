package com.internal.jwtapi.controller;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.internal.jwtapi.JwtApplication;
import com.internal.jwtapi.constants.AuthenticationConstants;
import com.internal.jwtapi.request.UserRequest;
import com.internal.jwtapi.service.UserService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

@RestController
@RequestMapping(value="/api/action/")
@NoArgsConstructor
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping(value = "createUser")
    public String createUser(@RequestBody UserRequest userRequest) {
        logger.info("User Creation Controller" + userRequest);
        userService.createUser(userRequest);
        return "Success";
    }

    @PostMapping(value = "generateToken")
    @ResponseBody
    public String generateToken(@RequestBody UserRequest userRequest) {
        logger.info("POST User Creation Controller" + userRequest);
        userService.createUser(userRequest);
        String response = "Success";
        //ResponseBody rb = ResponseBody;

        String token = JWT.create()
                .withSubject(userRequest.getUserName())
                .withClaim("password",userRequest.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes()));

        return token;
    }

    @PostMapping(value = "validateToken")
    @ResponseBody
    public String validateToken(@RequestBody UserRequest userRequest)
    {
        String token = userRequest.getToken();
        logger.info("Token Received as::"+token);
        String username;
        String password;
        try {
            DecodedJWT verify = JWT.require(Algorithm.HMAC512(AuthenticationConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(AuthenticationConstants.TOKEN_PREFIX, ""));

            username = verify.getSubject();
            password = verify.getClaim("password").asString();
            String role = verify.getClaim("role").asString();
        }catch (SignatureVerificationException signException)
        {
            logger.error("Token tampered");
            return "invalidToken";
        }
        return "valid : "+username + " Password :"+password;
    }
}
