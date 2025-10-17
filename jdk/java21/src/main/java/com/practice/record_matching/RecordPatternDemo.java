package com.practice.record_matching;

public class RecordPatternDemo {

  public static void main(String[] args) {
    Person person = new Person("Java", 21);
    checkRecordPattern(person);
    checkRecordPatternSwitch(person);
  }

  private static void checkRecordPatternSwitch(Person person) {
    switch (person) {
      case Person(String name, int version) -> System.out.printf("Person name - %s, version %s %n", name, version);
      case null -> System.out.println("Person is null");
      default -> System.out.println("Unknown person");
    }
  }

  private static void checkRecordPattern(Object obj) {
    if (obj instanceof Person(String name, int version)) {
      System.out.println("Person Name: " + name + ", Version: " + version);
    }
  }
}

record Person(String name, int version) { }
