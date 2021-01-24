package com.zoo.animal;

import com.zoo.exception.NegativeTimeException;

import java.util.Objects;

public class Penguin extends Animal implements Warmable {

    private int width;
    private int height;

    public Penguin() {
        // nothing here...
    }

    public Penguin(String name, Integer age) {
        super(name, age);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void findStone() {
        System.out.println("Камень найден!");
    }

    @Override
    public void say() {
        System.out.println("");
    }

    @Override
    public void warm(int minute) throws NegativeTimeException {
        if (minute < 0) {
            throw new NegativeTimeException("Время не может быть отрицательным числом");
        } else {
            System.out.println("Не люблю тепло");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Penguin penguin = (Penguin) o;
        return width == penguin.width &&
                height == penguin.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }
}
