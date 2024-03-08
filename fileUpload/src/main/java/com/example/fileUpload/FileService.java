package com.example.fileUpload;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileService {
    private final Path root = Paths.get("C:\\Users\\ricca\\Downloads");

    public String storeFile(MultipartFile file) {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
            return file.getOriginalFilename();
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il caricamento del file: " + e.getMessage());
        }
    }

    public Resource loadFile(String fileName) {
        try {
            Path file = root.resolve(fileName);
            return new FileSystemResource(file);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il caricamento del file: " + e.getMessage());
        }
    }
}
