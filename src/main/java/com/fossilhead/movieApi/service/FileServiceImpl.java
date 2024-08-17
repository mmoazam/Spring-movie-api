package com.fossilhead.movieApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

//        String fileName = file.getOriginalFilename();
//
//        String filePath = path + File.separator + fileName;
//
//        File folder = new File(path);
//
//        // create folder if not created
//        if (!folder.exists()) {
//            if (!folder.mkdir()) {
//                throw new IOException("Failed to create directory: " + path);
//            }
//        }
//
//        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//
//        return fileName;

        File folder = new File(path);
        folder.mkdirs(); // create directory and its parents if not exist

        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String filePath = new File(folder, fileName).getPath();

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        }

        return fileName;
    }

    @Override
    public InputStream downloadFile(String path, String fileName) throws FileNotFoundException {
        String filePath = path + File.separator + fileName;

        return new FileInputStream(filePath);
    }
}
