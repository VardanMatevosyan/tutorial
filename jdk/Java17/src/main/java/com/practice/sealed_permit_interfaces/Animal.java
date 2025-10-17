package com.practice.sealed_permit_interfaces;

public sealed interface Animal permits Dog {
  void move();
}
