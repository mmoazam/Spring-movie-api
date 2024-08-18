package com.fossilhead.movieApi.controllers;

import com.fossilhead.movieApi.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;


@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Value("${project.poster}")
    private String uploadPath;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestBody MultipartFile file
    ) throws IOException {
        System.out.println(uploadPath);
        String fileName = fileService.uploadFile(uploadPath, file);
        return ResponseEntity.ok("file uploaded: " +   fileName);
    }

    @GetMapping("/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        InputStream file = fileService.downloadFile(uploadPath, fileName);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(file, response.getOutputStream());

    }

}
