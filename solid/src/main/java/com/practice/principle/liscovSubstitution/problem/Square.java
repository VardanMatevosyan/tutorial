package com.practice.principle.liscovSubstitution.problem;

public class Square extends Rectangle {

    public Square() {
    }

    @Override
    public  void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}
