package com.zoo.animal;

import com.zoo.exception.NegativeTimeException;

import java.util.Objects;

public class Tiger extends Animal implements Climbable, Warmable {

    private int countStrip;

    public Tiger() {
        // nothing here...
    }

    public Tiger(String name, Integer age) {
        super(name, age);
    }

    public int getCountStrip() {
        return countStrip;
    }

    public void setCountStrip(int countStrip) {
        this.countStrip = countStrip;
    }

    public void wagTail() {
        System.out.println("Помахал хвостом");
    }

    @Override
    public void say() {
        System.out.println("р-р-р-р");
    }

    @Override
    public void climb(String subject) {
        System.out.println("Лезь сам на " + subject);
    }

    @Override
    public void warm(int minute) throws NegativeTimeException {
        if (minute < 0) {
            throw new NegativeTimeException("Время не может быть отрицательным числом");
        } else {
            System.out.println("Буду греться!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tiger tiger = (Tiger) o;
        return countStrip == tiger.countStrip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countStrip);
    }
}
