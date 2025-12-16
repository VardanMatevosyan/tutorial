package com.practice.interfaces;

/**
 * Test class to demonstrate Java 8 interface functionality.
 * It uses default and static methods in the Greeter interface.
 * Outputs greetings to the console.
 * Hello, Vardan!
 * Hello, World!
 * @see Greeter
 */
public class Test {
  public static void main(String[] args) {
    Greeter greeter = Greeter.createEnthusiastic();
    greeter.greet("Vardan");
    greeter.sayHello();
  }
}



