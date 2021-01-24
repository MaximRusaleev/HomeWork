package com.zoo.animal;

import com.zoo.exception.NegativeTimeException;
import com.zoo.exception.RefuseCompleteException;

import java.util.Objects;

public class Cat extends Animal implements Climbable, Warmable {

    private String color;

    public Cat() {
        // nothing here...
    }

    public Cat(Integer age) {
        this.age = age;
    }

    public Cat(String name, Integer age) {
        super(name, age);
    }

    public Cat(String name, Integer age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void catchMouse() {
        System.out.println("Мышь поймана!");
    }

    public void purr() {
        System.out.println("Мррр");
    }

    @Override
    public void say() {
        System.out.println("мяу");
    }

    @Override
    public void climb(String subject) throws RefuseCompleteException {
        if (subject.equals("Вода")) {
            throw new RefuseCompleteException("В воду не полезу!");
        }
        System.out.println("Уже на " + subject);
    }

    @Override
    public void warm(int minute) throws NegativeTimeException {
        if (minute < 0) {
            throw new NegativeTimeException("Время не может быть отрицательным числом");
        } else {
            System.out.println("Прогреюсь");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
