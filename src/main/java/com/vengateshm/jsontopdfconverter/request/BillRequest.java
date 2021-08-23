package com.vengateshm.jsontopdfconverter.request;

import com.vengateshm.jsontopdfconverter.dto.OrderDto;
import lombok.Data;

import java.util.List;

@Data
public class BillRequest {
    private List<OrderDto> orders;
    private double totalAmount;
    private boolean includeTaxDetail;
    private String roundOffText;
    private String gstText;
    private String centralGstText;
    private String stateGstText;
    private double roundOffAmount;
    private double gstAmount;
    private double centralGstAmount;
    private double stateGstAmount;
    private double grandTotal;
}
