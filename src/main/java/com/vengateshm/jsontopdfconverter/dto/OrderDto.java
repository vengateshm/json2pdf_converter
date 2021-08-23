package com.vengateshm.jsontopdfconverter.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String itemName;
    public int quantity;
    private double rate;
    private double amount;
}
