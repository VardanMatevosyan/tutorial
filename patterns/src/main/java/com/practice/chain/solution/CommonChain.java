package com.practice.chain.solution;

import java.util.Objects;

public class CommonChain  {

    Chain nextChain;

    public void sendToNextChain(Request request) {
        if (Objects.nonNull(nextChain)) {
            nextChain.send(request);
        }
    }

}
