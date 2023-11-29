package com.practice.oop.static_dynamic_binding;

class TklKeyboard extends Keyboard {

  @Override
  public String getType() {
    return "Mechanical";
  }

  public static String getCategory() {
    return "Tenkeyless";
  }

}