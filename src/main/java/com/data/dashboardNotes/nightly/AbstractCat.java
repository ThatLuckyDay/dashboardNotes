package com.data.dashboardNotes.nightly;

public abstract class AbstractCat {
    private String color;
    public abstract void isAlive();

    public void getTail() {
        System.out.println("Tail");
    }

    public final void touchHead() {
        System.out.println("Good");
    }
}
