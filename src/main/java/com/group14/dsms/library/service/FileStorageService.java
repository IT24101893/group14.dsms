package com.group14.dsms.library.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class FileStorageService<T> {

    private final ObjectMapper objectMapper;

    public FileStorageService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public List<T> read(Path filePath, com.fasterxml.jackson.core.type.TypeReference<List<T>> typeReference) throws Exception {
        if (Files.exists(filePath)) {
            return objectMapper.readValue(Files.newBufferedReader(filePath), typeReference);
        }
        return List.of();
    }

    public void write(Path filePath, List<T> data) throws Exception {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(Files.newBufferedWriter(filePath), data);
    }
}