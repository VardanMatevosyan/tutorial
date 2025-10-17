package com.practice.static_in_non_static_method;

public class StaticInsideDemo {
  private static final StaticInsideDemo DEMO = new StaticInsideDemo();

  public static void main(String[] args) {
    DEMO.test();
  }

  private void test() {
    // declaration of static enum and record inside non-static method
    record Point(int x, int y) {};
    enum STATE {IN_PROGRESS, ORDERED, DELIVERED};
    Point p = new Point(3, 3);


    System.out.println("Point record value x is " + p.x());
    System.out.println("STATE is " + STATE.DELIVERED.name());


    // Anonymous class with static method and static final field
    interface Calculator {
      int sum(int a, int b);
    }
    Calculator calculator = new Calculator() {
      static final int CONST = 5;
      {
        System.out.println("Inside non-static block");
      }
      @Override
      public int sum(int a, int b) {
        staticMethod();
        return a + b;
      }

      private static void staticMethod() {
        System.out.println("Static method was called with const " + CONST);
      }
    };
    calculator.sum(3, 4); // Call to trigger the static method inside the anonymous class



  }


}
