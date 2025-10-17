package com.practice.sealed_permit_interfaces;

public non-sealed class Dog implements Animal {
  @Override
  public void move() {
    System.out.println("Moving like a Dog");
  }
}
