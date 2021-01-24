package com.zoo.animal;

import com.zoo.exception.RefuseCompleteException;

public class Monkey extends Animal implements Climbable {

    public String colorEye;
    public Boolean trick;

    public Monkey() {
        // nothing here...
    }

    public Monkey(String name, Integer age) {
        super(name, age);
    }

    public String getColorEye() {
        return colorEye;
    }

    public void setColorEye(String colorEye) {
        this.colorEye = colorEye;
    }

    public Boolean getTrick() {
        return trick;
    }

    public void setTrick(Boolean trick) {
        this.trick = trick;
    }

    @Override
    public void say() {
        System.out.println("а-а-a-А");
    }

    public String jump() {
        return "Прыгать";
    }

    @Override
    public void climb(String subject) throws RefuseCompleteException {
        if (subject.equals("Вода")) {
            throw new RefuseCompleteException("В воду не полезу!");
        }
        System.out.println("Залезу на " + subject + " за банан!");
    }

}
