package com.renault.gdpr.domain;


import com.renault.gdpr.annotations.GDPR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger( "GDPRController" );

    @Autowired
    UserService gdprService;

    @PostMapping("/user")
    @GDPR
    public User plain(@RequestBody User user){
        logger.info( " Data in the User controller "+ user);
        return gdprService.createUser(user);
    }

    @PostMapping("/piiuser")
    public PIIUser encrypt(@RequestBody PIIUser user){
        logger.info( " Data in the PII controller "+ user);
        return gdprService.createPIIUser(user);
    }

}

