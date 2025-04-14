package com.practice.chain.solution;

import com.practice.chain.problem.ProblemClient;

import java.util.List;

/**
 * Demonstrates a clean and extensible approach to processing requests using
 * the Chain of Responsibility design pattern.
 * <p>
 * <b>Solution:</b> Each message delivery strategy is encapsulated in a separate {@code Chain} implementation.
 * The client builds a chain of handlers ({@code EmailSendChainElement}, {@code PhoneNumberSendChainElement}, etc.),
 * and each element decides whether it can handle the request or pass it to the next in the chain.
 * </p>
 * <p>
 * This design promotes separation of concerns, simplifies testing, and adheres to the
 * Open/Closed Principle — new sending strategies can be added without modifying existing code.
 * </p>
 * Key benefits include:
 * <ul>
 *     <li>Each chain element handles only one specific case, promoting clarity and modularity.</li>
 *     <li>The client remains decoupled from the message delivery logic — it simply forwards the request to the head of the chain.</li>
 *     <li>New delivery strategies (e.g., {@code SlackSendChainElement}) can be added without modifying existing code, adhering to the Open/Closed Principle.</li>
 * </ul>
 *
 * @see ProblemClient for the original implementation with complex conditional logic
 */
public class SolutionChainClientApp {
    public static void main(String[] args) {
        Chain headChain = ChainElement.buildChain(getChains(), new NoOperationSendChainElement());
        headChain.send(buildRequest());
    }

    private static List<Chain> getChains() {
        return List.of(new EmailSendChainElement(), new PhoneNumberSendChainElement());
    }

    private static Request buildRequest() {
        return Request.builder()
                .email("user@gmail.com")
                .phoneNumber(null)
                .message("What's up?")
                .build();
    }
}
