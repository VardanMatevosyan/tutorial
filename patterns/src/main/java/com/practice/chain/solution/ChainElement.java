package com.practice.chain.solution;

import java.util.List;

public interface ChainElement<T> {
    void setNext(T chain);

    static   <T extends ChainElement<T>> T buildChain(List<T> elements, T lastChainElement) {
        if (elements.isEmpty()) {
            return lastChainElement;
        }
        for (int i = 0; i < elements.size() - 1; i++) {
            T currentElement = elements.get(i);
            T nextElement = elements.get(i + 1);
            currentElement.setNext(nextElement);
        }
        return elements.get(0);
    }

}
