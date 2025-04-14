package com.practice.facade;


import com.practice.facade.imp.SecurityAuthFacadeImpl;
import com.practice.facade.model.Authentication;

/**
 * Demonstrates a simplified client implementation using the Facade design pattern.
 * <p>
 * This solution encapsulates the complexity of authentication logic into a single
 * high-level interface: {@code SecurityAuthFacade}. The client simply invokes the
 * {@code validate(String token)} method to perform all necessary checks and retrieve
 * the {@code Authentication} result.
 * </p>
 * <p>
 * This design promotes loose coupling, hides internal complexities, and makes the code
 * more readable, testable, and maintainable.
 * </p>
 *
 * @see FacadeProblemClient for the original implementation without the Facade pattern
 */
public class FacadeSolutionClient {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        SecurityAuthFacade securityAuthFacade = new SecurityAuthFacadeImpl();
        Authentication authentication = securityAuthFacade.validate("some jwt token here");
        System.out.println("Token is valid : " + authentication);
    }
}
