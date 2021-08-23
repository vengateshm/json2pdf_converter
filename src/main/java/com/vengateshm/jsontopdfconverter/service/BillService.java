package com.vengateshm.jsontopdfconverter.service;

import com.vengateshm.jsontopdfconverter.request.BillRequest;

import java.io.ByteArrayInputStream;

public interface BillService {
    ByteArrayInputStream generateBillPdf(BillRequest billRequest);
}
