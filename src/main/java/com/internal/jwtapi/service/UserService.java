package com.internal.jwtapi.service;

import com.internal.jwtapi.JwtApplication;
import com.internal.jwtapi.request.UserRequest;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class.getName());
    //private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void createUser(UserRequest userRequest) {
        logger.info("Create User Implementation");
    }
}
