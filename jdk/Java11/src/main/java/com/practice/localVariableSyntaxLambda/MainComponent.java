package com.practice.localVariableSyntaxLambda;


import java.util.function.BiFunction;


public class MainComponent {

  public static void main(String[] args) {
    BiFunction<String, Integer, String> function = (var a, var b) -> a + b;
    String message = function.apply("Hello ", 1);
    String messageWithNull = function.apply(null, 1);
    System.out.println("Message is " + message);
    System.out.println("Message is " + messageWithNull);

    // resume
    // var can be used like  (@NotNull var a, @Null var b) tested with spring boot,
    // but annotations for example with spring validation doesn't work.
  }

}
