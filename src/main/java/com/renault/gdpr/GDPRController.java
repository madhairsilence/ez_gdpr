package com.renault.gdpr;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GDPRController {

    private Logger logger = LoggerFactory.getLogger( "GDPRController" );

    @Autowired GDPRService gdprService;

    @PostMapping("/plain")
    public User plain(@RequestBody  User user){
        logger.info( " Data in the plain controller "+ user);
        return gdprService.create(user);
    }

    @PostMapping("/encrypt")
    @GDPR
    public User encrypt(@RequestBody  User user){
        logger.info( " Data in the encryption controller "+ user);
        return gdprService.create(user);
    }

}

