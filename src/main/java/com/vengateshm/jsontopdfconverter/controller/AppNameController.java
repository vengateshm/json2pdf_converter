package com.vengateshm.jsontopdfconverter.controller;

import com.vengateshm.jsontopdfconverter.config.AppProperties;
import com.vengateshm.jsontopdfconverter.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/v1")
public class AppNameController {

    @Autowired
    private AppProperties appProperties;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generateAppNamePdf() {
        ByteArrayInputStream in = PdfGenerator.generateAppNamePdf(appProperties.getName(),
                appProperties.getAuthor());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=app-name.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(in));
    }
}
