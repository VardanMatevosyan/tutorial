package com.practice.stream.collectors;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StackCollector<A> implements Collector<A, Stack<A>, Stack<A>> {

    @Override
    public Supplier<Stack<A>> supplier() {
        return Stack::new;
    }

    @Override
    public BiConsumer<Stack<A>, A> accumulator() {
        return Stack::push;
    }

    @Override
    public BinaryOperator<Stack<A>> combiner() {
        return (stack1, stack2) -> {
            stack1.addAll(stack2);
            return stack1;
        };
    }

    @Override
    public Function<Stack<A>, Stack<A>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
