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
    public String plain(@RequestBody  String text){
        logger.info( " Data in the plain controller "+ text);
        return gdprService.create(text);
    }

    @PostMapping("/encrypt")
    @GDPR
    public String encrypt(@RequestBody  String text){
        logger.info( " Data in the encryption controller "+ text);
        return gdprService.create(text);
    }

}

