package com.zoo.animal;

import com.zoo.exception.DoubleAnimalException;
import com.zoo.exception.FullAviaryException;

import java.util.HashSet;

public class Aviary {

    private HashSet<Animal> aviary;
    private int maxAnimalCount;

    public Aviary() {
        aviary = new HashSet<>();
        this.maxAnimalCount = 3;
    }

    public Aviary(int maxCount) {
        aviary = new HashSet<>();
        this.maxAnimalCount = maxCount;
    }

    public Aviary(HashSet<Animal> aviary) {
        this.aviary = aviary;
    }

    private Boolean checkDoubleAnimal(Animal animal) {
        for (Animal animalFor : aviary) {
            if (animalFor.equals(animal) && animalFor.hashCode() == animal.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public void addAnimal(Animal animal) throws FullAviaryException, DoubleAnimalException {
        if (aviary.size() == maxAnimalCount) {
            throw new FullAviaryException("Вольер заполнен");
        } else if (checkDoubleAnimal(animal)) {
            throw new DoubleAnimalException("Животное " + animal.getName() + " уже добавлено");
        } else {
            aviary.add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        aviary.remove(animal);
    }

    public HashSet<Animal> getAviary() {
        return aviary;
    }

    public void setAviary(HashSet<Animal> aviary) {
        this.aviary = aviary;
    }

    @Override
    public String toString() {
        String allInAviary = "";
        for (Animal a : aviary) {
            allInAviary += allInAviary.isBlank() ? a.name : ", " + a.name;
        }
        return allInAviary;
    }
}
