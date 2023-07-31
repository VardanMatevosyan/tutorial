package com.practice.principle.liscovSubstitution.solution;

import org.junit.Test;
import com.practice.principle.liscovSubstitution.problem.Rectangle;
import com.practice.principle.liscovSubstitution.problem.Square;

public class SquareTest {

    public  Rectangle rectangleFactory() {
        return new Square();
    }

    @Test
    public void whenUseLSP() {
        Rectangle r = rectangleFactory();
        r.setWidth(7);
        r.setHeight(3);

        System.out.println("Rectangle " + r.getArea());
    }

}
