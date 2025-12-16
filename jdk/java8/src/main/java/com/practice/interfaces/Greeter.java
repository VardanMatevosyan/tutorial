package com.practice.interfaces;

@FunctionalInterface
public interface Greeter {

  void greet(String name);

  default void sayHello() {
    greet("World");
  }

  static Greeter createEnthusiastic() {
    return name -> System.out.println("Hello, " + name + "!");
  }

}
