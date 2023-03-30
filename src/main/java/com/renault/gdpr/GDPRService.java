package com.renault.gdpr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GDPRService {

    private Logger logger = LoggerFactory.getLogger( "GDPRService" );

    public String create( String text ){
        logger.info( " Data inside create service " + text );
        return text;
    }
}

