package com.practice.pattern_matching_switch;

/**
 * Demonstrates pattern matching in switch statements.
 * Available in Java 21 and later.
 * Automatically handles type checks and casts.
 * Supports null handling.
 * Can return values from switch expressions and execute the task.
 * Can execute multiple statements in a case block.
 * Can use a default case for unmatched types.
 * Can be used with various data types including primitives, wrappers, and custom classes.
 * Can execute complex logic within case blocks.
 * Prints the type and value of the input object.
 */
public class PatternMatchingSwitchDemo {

  public static void main(String[] args) {
    checkValue(31);
    checkValue(31L);
    checkValue(null);

    executeTask(31);
  }

  private static void checkValue(Object obj) {
    String result = switch (obj) {
      case Integer i -> "It's an Integer: " + i;
      case String s -> "It's a String: " + s;
      case Double d -> "It's a Double: " + d;
      case null -> "It's null";
      default -> "Unknown type";
    };
    System.out.println(result);
  }

  private static void executeTask(int i) {
    switch (i) {
      case 1, 2, 3 -> System.out.println("Low value: " + i);
      case 4, 5, 6 -> {
        int square = i * i;
        System.out.println("Medium value: " + i + ", Square: " + square);
      }
      case 7, 8, 9 -> System.out.println("High value: " + i);
      default -> System.out.println("Value out of range: " + i);
    }
  }

}
