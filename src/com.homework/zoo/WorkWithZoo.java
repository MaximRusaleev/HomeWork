package com.zoo;

import com.zoo.animal.*;
import com.zoo.exception.DoubleAviaryNumberException;
import com.zoo.exception.NegativeTimeException;
import com.zoo.exception.RefuseCompleteException;

import java.util.LinkedList;
import java.util.List;

public class WorkWithZoo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setAge(5);
        cat.setSpeed(35);
        cat.setName("Мурзик");
        cat.say();
        try {
            cat.warm(-10);
            cat.climb("Вода");
        } catch (NegativeTimeException exception) {
            System.out.println(exception.getMessage());
        } catch (RefuseCompleteException exception) {
            System.out.println(exception.getMessage());
        }

        List<Animal> animalList = new LinkedList<>();
        animalList.add(cat);
        animalList.add(new Deer("Бэмби", 3, true));
        animalList.add(new Deer("Бэмби", 3, true));
        animalList.add(new Penguin("Лоло", 2));
        animalList.add(new Monkey("Чичи", 4));
        System.out.println("Вольер:");
        Aviary aviary = new Aviary(3);
        for (Animal animal : animalList) {
            try {
                aviary.addAnimal(animal);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(aviary.toString());
        Zoo zoo = new Zoo(2);
        try {
            zoo.addAviary(1, aviary);
            zoo.addAviary(2, new Aviary());
            zoo.addAnimalInAviary(2, new Tiger("Тиграша", 8));
        } catch (DoubleAviaryNumberException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(zoo.toString());

    }
}
