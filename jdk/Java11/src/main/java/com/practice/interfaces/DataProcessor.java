package com.practice.interfaces;

public interface DataProcessor {

  default void process(String data) {
    String cleaned = sanitize(data);
    System.out.println("Processed: " + cleaned);
  }

  private String sanitize(String input) {
    return input.trim().toLowerCase();
  }

  @SuppressWarnings("checkstyle:WhitespaceAround")
  static DataProcessor create() {
    return new DataProcessor() {
    };
  }
}
