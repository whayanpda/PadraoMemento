package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Originator o = new Originator();
        CareTaker ct = new CareTaker(o);

    ct.saveState();
    o.moveLeft();
    o.moveLeft();
    o.moveRight();
    o.moveRight();
    ct.saveState();
    o.moveLeft();
    o.moveRight();
    ct.saveState();
    ct.undo();
    ct.undo();
    ct.undo();

    }
}