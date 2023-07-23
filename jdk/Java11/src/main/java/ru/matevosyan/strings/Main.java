package ru.matevosyan.strings;

public class Main {

  public static void main(String[] args) {
    isBlank("some string"); // false
    isBlank(""); // true
    isBlank("      "); // true

  }

  private static void isBlank(String str) {
    boolean blank = str.isBlank();
    System.out.println(blank);
  }

}
