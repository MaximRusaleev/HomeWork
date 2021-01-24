package com.zoo.animal;

import com.zoo.exception.NegativeTimeException;

import java.util.Objects;

public class Deer extends Animal implements Warmable {

    private Boolean spot;

    public Deer() {
        // nothing here...
    }

    public Deer(String name, Integer age, Boolean spot) {
        super(name, age);
        this.spot = spot;
    }

    public Boolean getSpot() {
        return spot;
    }

    public void setSpot(Boolean spot) {
        this.spot = spot;
    }

    @Override
    public void say() {
        System.out.println("фыр");
    }

    @Override
    public void warm(int minute) throws NegativeTimeException {
        if (minute < 0) {
            throw new NegativeTimeException("Время не может быть отрицательным числом");
        } else {
            System.out.println("Можно высохнуть");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Deer deer = (Deer) o;
        return Objects.equals(spot, deer.spot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spot);
    }
}
