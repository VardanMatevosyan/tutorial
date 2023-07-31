package com.practice.strings;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    System.out.println("=== Testing isBlank ===");
    isBlank("some string"); // false
    isBlank(""); // true
    isBlank("      "); // true
    System.out.println();


    System.out.println("=== Testing lines ===");
    lines();
    System.out.println();


    System.out.println("=== Testing strip, stripLeading, stripTrailing ===");
    strip();
    System.out.println();


    System.out.println("=== Testing repeat ===");
    repeat(4);
    System.out.println();


    System.out.println("=== Testing Optional.isEmpty ===");
    optionalEmptyString("");
    optionalEmptyString("     ");
    optionalEmptyString("some text");
    optionalEmptyString(null);
    System.out.println();


    System.out.println("=== Testing  ===");
    readAndWriteString("some string here");
    System.out.println();


  }

  private static void isBlank(String str) {
    boolean blank = str.isBlank();
    System.out.println(blank);
  }

  private static void lines() {
    var firstLine = " first line here       ";
    var secondLine = " second line here ";
    var thirdLine = " third line here ";
    var multilineString = firstLine + "\n" + secondLine + "\n" + thirdLine + "\n";

    var stringLines = multilineString
        .lines()
        .map(String::trim)
        .collect(toList());

    stringLines.forEach(System.out::println);
    System.out.println("Contains first line = " + stringLines.get(0).contains(firstLine.trim()));
    System.out.println("Contains second line = " + stringLines.get(1).contains(secondLine.trim()));
    System.out.println("Contains third line = " + stringLines.get(2).contains(thirdLine.trim()));

    // resume
    // using lines() allows easily convert multiline to list of string values
    // output
    //first line here
    //second line here
    //third line here
    //Contains first line = true
    //Contains second line = true
    //Contains third line = true
  }

  private static void strip() {
    var firstLine = "  first line here       ";
    var expectedStripValue = "first line here";
    var expectedStripTrailingValue = "  first line here";
    var expectedStripLeadingValue = "first line here       ";

    System.out.println("Strip = " + firstLine.strip().equals(expectedStripValue));
    System.out.println("Strip trailing = " + firstLine.stripTrailing().equals(expectedStripTrailingValue));
    System.out.println("Strip leading = " + firstLine.stripLeading().equals(expectedStripLeadingValue));

    // output
    // Strip = true
    // Strip trailing = true
    // Strip leading = true
  }

  private static void repeat(int times) {
    var welcomeString = "Welcome";
    String repeatedString = welcomeString.repeat(times);
    System.out.println("Repeated " + times + " times is = " + repeatedString);

    // output
    // Repeated 4 times is = WelcomeWelcomeWelcomeWelcome
  }

  private static void optionalEmptyString(String value) {
    Optional<String> optionalString = Optional.ofNullable(value);
    boolean isEmptyValue = optionalString.isEmpty();
    System.out.println("Optional value = " + value + " is empty = " + isEmptyValue);

    // resume
    // Optional isEmpty checks for null where's isPresent checks for not null.
    // output
    //  Optional value =  is empty = false
    //  Optional value =       is empty = false
    //  Optional value = some text is empty = false
    //  Optional value = null is empty = true
  }

  private static void readAndWriteString(String value) {
    var path = Path.of("/home/vardan/data.txt");
    try {
      Files.writeString(path, value, StandardOpenOption.APPEND);
      String stringFromFile = Files.readString(path);
      System.out.println("String value from file is " + stringFromFile);
      System.out.println("String value from is the same - " + stringFromFile.equals(value));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // Files.writeString creates the file with provided string value or append the value if
    // APPEND option was provided.
    // Files.readString reads the string from the file.

    // output
    // String value from file is some string here
    //String value from is the same - true
  }

}
