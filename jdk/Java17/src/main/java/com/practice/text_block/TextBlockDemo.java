package com.practice.text_block;

public class TextBlockDemo {

  public static void main(String[] args) {
    textBlock();
  }

  private static void textBlock() {
    String textBlock = """
        Welcome to
        Java 17 new Text Block
        Finally""";
    System.out.println(textBlock);
  }

}
