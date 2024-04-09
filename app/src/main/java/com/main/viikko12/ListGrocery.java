package com.main.viikko12;

import java.util.ArrayList;

public class ListGrocery {

    private ArrayList<Grocery> groceries = new ArrayList<>();

    private static ListGrocery groceryList = null;

    private ListGrocery() {

    }

    public void removeGrocery(String name) {
        int i = 0;
        for (Grocery g : groceries) {
            if (g.getName().equals(name)) {
                break;
            }
            i++;
        }
        groceries.remove(i);
    }

    public static ListGrocery getInstance() {
        if (groceryList == null) {
            groceryList = new ListGrocery();
        }
        return groceryList;

    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public Grocery getGroceryByName(String name) {
        int i = 0;
        for (Grocery g : groceries) {
            if (g.getName().equals(name)) {
                break;
            }
            i++;
        }
        return groceries.get(i);
    }
}