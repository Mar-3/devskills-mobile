package org.mar_3.shoppingapp;

public class Item {

    private String name;
    private int amount;
    private String category;
    public Item(String name, int amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }
}
