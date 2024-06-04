package com.data.dashboardNotes.nightly;

public final class Cat extends AbstractCat implements CatEat {
    private static final String catAsk = "Mew";

    public Cat() {
    }

    public static void main(String[] args) {
        Cat cat = new Cat();

        TypeCat<Cat> tCat = new TypeCat<>(cat);

        Thread innerCatThread = new InnerCatThread();
        innerCatThread.start();

        Runnable innerCatRunnable = new InnerCatRunnable();
        Thread runableThread = new Thread(innerCatRunnable);
        runableThread.start();
    }

    @Override
    public void eat() {
        System.out.println(catAsk);
    }

    @Override
    public void isAlive() {
        System.out.println("Alive");
    }

    @Override
    public void getTail() {
        System.out.println("Some tail");
    }

    private static class InnerCatThread extends Thread {
        public InnerCatThread() {
            super("Cat Thread");
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " " + this.isAlive() + " ");
        }
    }

    private static class InnerCatRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(this);
        }
    }

}
