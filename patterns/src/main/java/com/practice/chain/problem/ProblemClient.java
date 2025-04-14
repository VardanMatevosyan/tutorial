package com.practice.chain.problem;

import com.practice.chain.solution.Request;
import com.practice.chain.solution.SolutionChainClientApp;

import java.util.Objects;

/**
 * Demonstrates a naive approach to processing a request with conditional logic.
 * <p>
 * <b>Problem:</b> This implementation uses multiple {@code if-else} branches to determine
 * how to send a message based on available contact information.
 * As more channels are introduced (e.g., push notification, Slack, etc.), the logic becomes
 * more complex, harder to read, and difficult to maintain.
 * <p>
 * -> This violates the Single Responsibility Principle and tightly couples decision logic with execution logic.
 * In this approach, all logic — including decision-making and behavior — is concentrated in the client class.
 * <p>
 * As a result, a single method is responsible for:
 * <ul>
 *     <li>Determining which message delivery strategy to use</li>
 *     <li>Executing the message sending logic</li>
 *     <li>Handling fallback behavior or errors when no strategy is applicable</li>
 * </ul>
 * -> This violates the Open/Closed Principle, since each new case requires modifying this class.
 * </p>
 *
 * @see SolutionChainClientApp for the refactored version using the Chain of Responsibility pattern
 */
public class ProblemClient {
    public static void main(String[] args) {
        Request request = buildRequest();
        if (Objects.nonNull(request.getEmail())) {
            System.out.println("Send via email");
        } else if (Objects.nonNull(request.getPhoneNumber())) {
            System.out.println("Send via phone");
        } else {
            System.out.println("Can't send the message. No method available.");
        }
    }


    private static Request buildRequest() {
        return Request.builder()
                .email("user@gmail.com")
                .phoneNumber(null)
                .message("What's up?")
                .build();
    }
}
