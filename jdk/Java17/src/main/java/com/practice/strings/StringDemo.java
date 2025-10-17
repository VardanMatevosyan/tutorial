package com.practice.strings;

public class StringDemo {

  public static void main(String[] args) {
    formatedStr("Java %d");
    System.out.println("-----------");
    indentation();
    System.out.println("-----------");
  }

  private static void formatedStr(String str) {
    System.out.println();
    System.out.println("Formatted method");
    System.out.println();
    String formatted = str.formatted(17);
    System.out.println(formatted);
  }

  private static void indentation() {
    System.out.println();
    System.out.println("Indent method");
    System.out.println();
    String textBlock = """
        Some str
        and here
        no indentation""";
    System.out.println(textBlock);
    System.out.println();
    String indented = textBlock.indent(10);
    System.out.println(indented);
  }

}
