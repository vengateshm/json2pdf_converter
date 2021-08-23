package com.vengateshm.jsontopdfconverter.service;

import com.vengateshm.jsontopdfconverter.request.BillRequest;
import com.vengateshm.jsontopdfconverter.util.PdfGenerator;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class BillServiceImpl implements BillService{
    @Override
    public ByteArrayInputStream generateBillPdf(BillRequest billRequest) {
        return PdfGenerator.generateBillPdf(billRequest);
    }
}
