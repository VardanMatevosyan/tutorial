package com.practice.facade;


import com.practice.facade.imp.AuthenticatorFactoryImpl;
import com.practice.facade.imp.SecurityJwksVerifierImpl;
import com.practice.facade.imp.SecurityJwtServiceImpl;
import com.practice.facade.model.Authentication;

import java.util.Map;

/**
 * Demonstrates a client implementation that suffers from tight coupling and complexity
 * due to direct interactions with multiple low-level authentication services.
 * <p>
 * This example represents the problem scenario before applying the Facade design pattern.
 * The client is responsible for coordinating the calls to different components:
 * <ul>
 *     <li>{@code SecurityJwksVerifier} – to verify the JWT signature.</li>
 *     <li>{@code SecurityJwtService} – to validate issuer and extract claims.</li>
 *     <li>{@code AuthenticatorFactory} – to build the final {@code Authentication} object.</li>
 * </ul>
 * This design violates the principle of least knowledge and results in code that is harder to maintain and scale.
 * </p>
 *
 * @see FacadeSolutionClient for the improved version using the Facade pattern
 */
public class FacadeProblemClient {


    public static void main(String[] args) {
        problem();
    }

    private static void problem() {
        SecurityJwksVerifier securityJwksVerifier =  new SecurityJwksVerifierImpl();
        SecurityJwtService securityJwtService =  new SecurityJwtServiceImpl();
        AuthenticatorFactory authenticatorFactory =  new AuthenticatorFactoryImpl();

        String token = "some token here";
        boolean verifiedToken = securityJwksVerifier.verify(token);
        boolean validIssuer = securityJwtService.validateIssuer(token);
        if (verifiedToken && validIssuer) {
            Map<String, String> claimSet = securityJwtService.extractClaimSet(token);
            Authentication authentication = authenticatorFactory.build(claimSet);
            System.out.println("Token is valid : " + authentication);
        } else {
            throw new RuntimeException("Signed token is not valid");
        }
    }
}
