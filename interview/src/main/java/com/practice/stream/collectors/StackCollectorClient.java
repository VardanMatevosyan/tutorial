package com.practice.stream.collectors;

import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StackCollectorClient {
    public static void main(String[] args) {
        // first approach using class  just for practice
        Stack<Integer> numberStack = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .filter(x -> x <= 5)
                .collect(new StackCollector<>());

        while (!numberStack.isEmpty()) {
            System.out.println(numberStack.pop());
        }

        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


        // second approach
        Stack<Integer> numberStack2 = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .filter(x -> x <= 5)
                .collect(toStack());

        while (!numberStack2.isEmpty()) {
            System.out.println(numberStack2.pop());
        }

    }

    private static Collector<? super Integer, ?, Stack<Integer>> toStack() {
        return Collector.of(
                Stack::new,
                Stack::push,
                (stack1, stack2) -> {
                    stack1.addAll(stack2);
                    return stack1;
                }
        );
    }
}
