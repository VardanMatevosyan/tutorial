package ru.matevosyan.principle.liscovSubstitution.problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    public  Rectangle RectangleFactory() {
        return new Square();
    }

    @Test
    public void whenDonotUseLSP() {
        Rectangle r = RectangleFactory();
        r.setWidth(7);
        r.setHeight(3);

        System.out.println("Rectangle " + r.getArea());
    }
}