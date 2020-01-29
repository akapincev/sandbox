package com.akapincev.springrest.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/{customerId}/{category}")
    public String uploadFile(@PathVariable String customerId,
                             @PathVariable String category,
                             @RequestPart MultipartFile file) {
        log.info("Receive Post Request on endpoint /document/{}/{} for file {}", customerId, category, file.getOriginalFilename());
        return this.documentService.uploadDocument(customerId, category, file);
    }

}
