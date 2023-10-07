package org.mar_3.shoppingapp;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ItemList implements Serializable {
    private LocalDateTime date;
    private String name;
    private ArrayList<String> categories;
    private ArrayList<Item> items;

    public ItemList(String name ) {
        this.items = new ArrayList<Item>();
        this.date = LocalDateTime.now();
        this.name = name;
        this.categories = new ArrayList<String>();
    }
    public void addItem(Item item) {
        this.items.add(item);
        if ( !categories.contains(item.getCategory())) {
            categories.add(item.getCategory());
        }
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
    public ItemList getItemsByCategory(String category) {
        ItemList itemsByCategory = new ItemList(category);

        for (int i = 0;i < this.getSize();i++) {
            if (this.items.get(i).getCategory().equals(category)) {
                itemsByCategory.addItem(this.items.get(i));
            }
        }
        if (itemsByCategory.getSize() == 0) {
            return null;
        }

        return itemsByCategory;
    }

    public int getSize() {
        return getItems().size();
    }
}
