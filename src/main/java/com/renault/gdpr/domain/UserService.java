package com.renault.gdpr.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger( "GDPRService" );

    @Autowired UserRepository userRepository;
    @Autowired PIIUserRepository piiUserRepository;

    public User createUser(User user ){
        logger.info( " Data inside create service " + user );
        return userRepository.save( user );
    }

    public PIIUser createPIIUser(PIIUser user ){
        logger.info( " Data inside create service " + user );
        return piiUserRepository.save( user );
    }
}

