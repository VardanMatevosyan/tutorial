package ru.matevosyan.principle.liscovSubstitution.solution;

import org.junit.Test;
import ru.matevosyan.principle.liscovSubstitution.problem.Rectangle;
import ru.matevosyan.principle.liscovSubstitution.problem.Square;

import static org.junit.Assert.*;

public class SquareTest {

    public  Rectangle RectangleFactory() {
        return new Square();
    }

    @Test
    public void whenUseLSP() {
        Rectangle r = RectangleFactory();
        r.setWidth(7);
        r.setHeight(3);

        System.out.println("Rectangle " + r.getArea());
    }

}