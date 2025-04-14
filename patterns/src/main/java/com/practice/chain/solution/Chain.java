package com.practice.chain.solution;

public interface Chain extends ChainElement<Chain> {

    void send(Request request);

}
