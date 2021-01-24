package com.zoo;

import com.zoo.animal.Animal;
import com.zoo.animal.Aviary;
import com.zoo.exception.DoubleAviaryNumberException;
import com.zoo.exception.FullZooException;
import com.zoo.exception.NotFoundAviaryException;

import java.util.HashMap;

public class Zoo {
    private HashMap<Integer, Aviary> zoo;
    private int maxAviaryCount;

    public Zoo() {
        zoo = new HashMap<>();
        this.maxAviaryCount = 3;
    }

    public Zoo(int maxAviaryCount) {
        zoo = new HashMap<>();
        this.maxAviaryCount = maxAviaryCount;
    }

    public Zoo(HashMap<Integer, Aviary> zoo) {
        this.zoo = zoo;
    }

    private Boolean checkNumberAviary(Integer number) {
        if (zoo.containsKey(number)) {
            return true;
        }
        return false;
    }

    public void addAviary(Integer numberAviary, Aviary aviary) throws FullZooException, DoubleAviaryNumberException {
        if (zoo.size() == maxAviaryCount) {
            throw new FullZooException("Достигнуто максимальное количество вольеров");
        }
        if (checkNumberAviary(numberAviary)) {
            throw new DoubleAviaryNumberException("Вольер с таким номером уже добавлен");
        } else {
            zoo.put(numberAviary, aviary);
        }
    }

    public void addAnimalInAviary(Integer numberAviary, Animal animal) throws NotFoundAviaryException {
        if (!checkNumberAviary(numberAviary)) {
            throw new NotFoundAviaryException("Вольера с таким номером не существует");
        } else {
            try {
                zoo.get(numberAviary).addAnimal(animal);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        for (HashMap.Entry<Integer, Aviary> item : zoo.entrySet()) {
            System.out.println("Вольер: " + item.getKey() + " - Обитатели: " + item.getValue().toString());
        }
        return "В зоопарке вольеров " + maxAviaryCount;
    }
}
