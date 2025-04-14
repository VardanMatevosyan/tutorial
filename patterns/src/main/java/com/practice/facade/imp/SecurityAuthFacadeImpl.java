package com.practice.facade.imp;

import com.practice.facade.AuthenticatorFactory;
import com.practice.facade.SecurityAuthFacade;
import com.practice.facade.SecurityJwksVerifier;
import com.practice.facade.SecurityJwtService;
import com.practice.facade.model.Authentication;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * Problem
 * If we are using many objects or services and these objects for example depends on each other,
 * or we have different operations to do to complete the business logic process.
 * Business logic of the classes used for specific logic
 * would become tightly coupled to the implementation details
 * For examole imagine that we are working with 3-party library
 * and have lots of objects and method invocation and also can be harder when the order is meter.
 * If we needed some process with all of that directly it would harder to:
 * 1. Maintain each plays we were are using this library
 * 2. Hard to found the defect.
 * If library has many similar method, some users can invoke wrong one, which can cause the defect in the future.
 * ---------------------------------------------------------------------------------------------------------------
 * Solution
 * Using the facade pattern
 * A Facade is a class the provides a simple interface to a complex subsystems which contains
 * lots of moving parts.
 * A facade might provide limited functionality in comparison to working with
 * subsystems directly.
 * ---------------------------------------------------------------------------------------------------------------
 * Outcome
 * Clients don't know the detail of implementation
 * No need to directly communicate with objects and they dependencies
 * Easy to fix. Less chance to make a mistake when there are many specific invocation or state or params to set
 * Easy to maintain. For example ff need to change business logic, and we are using this logic in many places.
 *

 */
@AllArgsConstructor
public class SecurityAuthFacadeImpl implements SecurityAuthFacade {

    SecurityJwksVerifier securityJwksVerifier;
    SecurityJwtService securityJwtService;
    AuthenticatorFactory authenticatorFactory;

    public SecurityAuthFacadeImpl() {
        this.securityJwksVerifier = new SecurityJwksVerifierImpl();
        this.securityJwtService = new SecurityJwtServiceImpl();
        this.authenticatorFactory = new AuthenticatorFactoryImpl();
    }

    @Override
    public Authentication validate(String token) {
        boolean verifiedToken = securityJwksVerifier.verify(token);
        boolean validIssuer = securityJwtService.validateIssuer(token);
        if (verifiedToken && validIssuer) {
            Map<String, String> claimSet = securityJwtService.extractClaimSet(token);
            Authentication authentication = authenticatorFactory.build(claimSet);
            System.out.println("Token is valid");
            return authentication;
        } else {
            throw new RuntimeException("Signed token is not valid");
        }
    }

}
