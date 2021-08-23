package com.vengateshm.jsontopdfconverter.model;

import lombok.Data;

@Data
public class Order {
    private String itemName;
    public int quantity;
    private double price;
    private double rate;
    private double amount;
}
