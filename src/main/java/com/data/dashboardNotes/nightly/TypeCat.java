package com.data.dashboardNotes.nightly;

public class TypeCat<T> {
    private T typeCat;

    public TypeCat(T typeCat) {
        this.typeCat = typeCat;
    }

    T getTypeCat() {
        return typeCat;
    }

    void showType() {
        System.out.println("Тип T: " + typeCat.getClass().getName());
    }
}
