package com.group14.dsms.library.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.group14.dsms.library.model.Instructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class InstructorService {

    private final Path filePath = Path.of("src/main/resources/data/instructors.json");
    private static int instructorIdCounter = 1;
    private final FileStorageService<Instructor> fileStorageService;

    public InstructorService(FileStorageService<Instructor> fileStorageService) throws Exception {
        this.fileStorageService = fileStorageService;
        initializeIdCounter();
    }

    private void initializeIdCounter() throws Exception {
        List<Instructor> instructors = getAllInstructors();
        if (!instructors.isEmpty()) {
            instructorIdCounter = instructors.stream()
                    .mapToInt(instructor -> Integer.parseInt(instructor.getId().substring(1)))
                    .max()
                    .orElse(0) + 1;
        }
    }

    public List<Instructor> getAllInstructors() throws Exception {
        return fileStorageService.read(filePath, new TypeReference<>() {});
    }

    public Instructor getInstructorById(String id) throws Exception {
        return getAllInstructors().stream()
                .filter(instructor -> instructor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveAllInstructors(List<Instructor> instructors) throws Exception {
        fileStorageService.write(filePath, instructors);
    }

    public void addInstructor(Instructor instructor) throws Exception {
        List<Instructor> instructors = getAllInstructors();
        instructor.setId(String.format("I%03d", instructorIdCounter++));
        instructors.add(instructor);
        saveAllInstructors(instructors);
    }

    public void updateInstructor(String id, Instructor updatedInstructor) throws Exception {
        List<Instructor> instructors = getAllInstructors();
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId().equals(id)) {
                updatedInstructor.setId(id);
                instructors.set(i, updatedInstructor);
                saveAllInstructors(instructors);
                return;
            }
        }
        throw new Exception("Instructor with ID " + id + " not found.");
    }

    public void deleteInstructor(String id) throws Exception {
        List<Instructor> instructors = getAllInstructors();
        boolean removed = instructors.removeIf(instructor -> instructor.getId().equals(id));
        if (removed) {
            saveAllInstructors(instructors);
        } else {
            throw new Exception("Instructor with ID " + id + " not found.");
        }
    }
}