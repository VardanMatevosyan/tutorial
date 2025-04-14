package com.practice.chain.solution;

public class NoOperationSendChainElement extends CommonChain implements Chain {
    @Override
    public void send(Request request) {
        System.out.println("Can't send message. No method found");
    }

    @Override
    public void setNext(Chain chain) {
        System.out.println("No operation for this element");
    }
}
