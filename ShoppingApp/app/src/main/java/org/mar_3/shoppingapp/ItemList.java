package org.mar_3.shoppingapp;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ItemList {
    private LocalDateTime date;
    private String name;
    private ArrayList<Item> items;

    public ItemList(String name ) {
        this.items = new ArrayList<Item>();
        this.date = LocalDateTime.now();
        this.name = name;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }
    public LocalDateTime getDate() {
        return this.date;
    }
    public Item getItemByName(String name) {
        for (int i = 0;i < this.getSize();i++) {
            if (this.items.get(i).getName().equals(name)) {
                return this.items.get(i);
            }
        }
        return null;
    }

    public void removeItemByPosition(int position) {
        this.items.remove(position);
    }
    public ArrayList<Item> getItemsByCategory(String category) {
        ArrayList<Item> itemsByCategory = new ArrayList<Item>();

        for (int i = 0;i < this.getSize();i++) {
            if (this.items.get(i).getCategory().equals(category)) {
                itemsByCategory.add(this.items.get(i));
            }
        }
        if (itemsByCategory.isEmpty()) {
            return null;
        }

        return itemsByCategory;
    }

    public int getSize() {
        return getItems().size();
    }
}
