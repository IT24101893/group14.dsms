package com.group14.dsms.library.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.group14.dsms.library.model.Student;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class StudentService {

    private final Path filePath = Path.of("src/main/resources/data/students.json");
    private static int studentIdCounter = 1; // Static counter for unique IDs
    private final FileStorageService<Student> fileStorageService;

    // Constructor injection for FileStorageService
    public StudentService(FileStorageService<Student> fileStorageService) throws Exception {
        this.fileStorageService = fileStorageService;
        initializeIdCounter(); // Initialize the ID counter after dependencies are injected
    }

    // Initialize the ID counter based on the highest ID in the existing data
    private void initializeIdCounter() throws Exception {
        List<Student> students = getAllStudents();
        if (!students.isEmpty()) {
            studentIdCounter = students.stream()
                    .mapToInt(student -> Integer.parseInt(student.getId().substring(1))) // Extract numeric part
                    .max()
                    .orElse(0) + 1;
        }
    }

    public List<Student> getAllStudents() throws Exception {
        return fileStorageService.read(filePath, new TypeReference<>() {});
    }

    public Student getStudentById(String id) throws Exception {
        return getAllStudents().stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveAllStudents(List<Student> students) throws Exception {
        fileStorageService.write(filePath, students);
    }

    public void addStudent(Student student) throws Exception {
        List<Student> students = getAllStudents();
        student.setId(String.format("S%03d", studentIdCounter++)); // Generate ID like S001, S002, etc.
        students.add(student);
        saveAllStudents(students);
    }

    public void updateStudent(String id, Student updatedStudent) throws Exception {
        List<Student> students = getAllStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                updatedStudent.setId(id); // Ensure the ID remains unchanged
                students.set(i, updatedStudent);
                saveAllStudents(students);
                return;
            }
        }
        throw new Exception("Student with ID " + id + " not found.");
    }

    public void deleteStudent(String id) throws Exception {
        List<Student> students = getAllStudents();
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            saveAllStudents(students);
        } else {
            throw new Exception("Student with ID " + id + " not found.");
        }
    }
}