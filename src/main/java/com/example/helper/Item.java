package com.example.helper;

public class Item {
    private String key;
    private String label;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Item(String key, String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public String toString() {
        return label; // Hiển thị tên trên JComboBox
    }
}