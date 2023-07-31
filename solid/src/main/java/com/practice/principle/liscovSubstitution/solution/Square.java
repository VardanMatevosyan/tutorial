package com.practice.principle.liscovSubstitution.solution;

public class Square extends Quadrilaterals {
    private int size;

    public Square() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    int getArea() {
        return size * size;
    }
}
