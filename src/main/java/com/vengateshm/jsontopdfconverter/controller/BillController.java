package com.vengateshm.jsontopdfconverter.controller;

import com.vengateshm.jsontopdfconverter.request.BillRequest;
import com.vengateshm.jsontopdfconverter.service.BillServiceImpl;
import com.vengateshm.jsontopdfconverter.util.PdfGenerator;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class BillController {
    public BillServiceImpl billService;

    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/bill/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generateBillPdf(@RequestBody BillRequest billRequest) {
        ByteArrayInputStream in = PdfGenerator.generateBillPdf(billRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=bill.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(in));
    }
}
