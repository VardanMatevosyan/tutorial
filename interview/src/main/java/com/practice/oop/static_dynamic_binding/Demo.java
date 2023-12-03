package com.practice.oop.static_dynamic_binding;

/**
 * Example of static and dynamic binding in Java.
 */
public class Demo {

  public static void main(String[] args) {
    Keyboard current = new TklKeyboard();
    // Dynamic binding by the object
    String type = current.getType();

    // Static binding by the class or type reference
    String categoryUsingObject = current.getCategory();
    // or
    String parentCategoryUsingType = Keyboard.getCategory();
    // or
    String childCategoryUsingType = TklKeyboard.getCategory();

    System.out.println("(Binding type) - usage");
    System.out.println("(Dynamic)      - type : " + type);
    System.out.println("(Static)       - category using object : " + categoryUsingObject);
    System.out.println("(Static)       - category using parent type : " + parentCategoryUsingType);
    System.out.println("(Static)       - category using child type : " + childCategoryUsingType);
  }

}
