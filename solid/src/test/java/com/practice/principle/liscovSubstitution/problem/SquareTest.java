package com.practice.principle.liscovSubstitution.problem;

import org.junit.Test;

public class SquareTest {

    public  Rectangle rectangleFactory() {
        return new Square();
    }

    @Test
    public void whenDonotUseLSP() {
        Rectangle r = rectangleFactory();
        r.setWidth(7);
        r.setHeight(3);

        System.out.println("Rectangle " + r.getArea());
    }
}
