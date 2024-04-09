package com.main.viikko12;

public class Grocery {

    private String name;
    private String note;

    private boolean isImportant;

    public Grocery(String name, String note, Boolean isImportant) {
        this.name = name;
        this.note = note;
        this.isImportant = isImportant;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public boolean isImportant() {
        return isImportant;
    }
}