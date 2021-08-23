package com.vengateshm.jsontopdfconverter.request;

import com.vengateshm.jsontopdfconverter.dto.OrderDto;
import lombok.Data;

import java.util.List;

@Data
public class BillRequest {
    private List<OrderDto> orders;
    private double totalAmount;
}
