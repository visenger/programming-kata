package de.bhtb.external.data.dao.entities;

import java.util.List;

/**
 * Created by visenger on 28/03/17.
 */
public class Order {

    private int id;
    private List<String> items;
    private String date;

    public Order(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

        public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
