package com.zoo.animal;

import java.util.Objects;

public abstract class Animal {

    protected String name;
    protected Integer age;
    protected Integer speed;

    public Animal() {

    }

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public abstract void say();

    public Integer move() {
        return (int) (speed * 0.5);
    }

    public Integer move(Integer distance) {
        return distance / speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(age, animal.age) &&
                Objects.equals(speed, animal.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, speed);
    }
}
