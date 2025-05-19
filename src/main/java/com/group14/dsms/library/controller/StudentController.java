package com.group14.dsms.library.controller;

import com.group14.dsms.library.model.Student;
import com.group14.dsms.library.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor injection for StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        try {
            List<Student> students = studentService.getAllStudents();
            model.addAttribute("students", students);
            return "students";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving student data.");
            return "error";
        }
    }

    @GetMapping("/add-student")
    public String showAddStudentForm() {
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam String name, @RequestParam int age,
                             @RequestParam String phone, @RequestParam String address) {
        try {
            Student student = new Student(name, age, phone, address); // ID will be auto-assigned
            studentService.addStudent(student);
            return "redirect:/students";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(@PathVariable String id, Model model) {
        try {
            List<Student> students = studentService.getAllStudents();
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    model.addAttribute("student", student);
                    return "edit-student";
                }
            }
            return "error";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable String id, @RequestParam String name, @RequestParam int age,
                              @RequestParam String phone, @RequestParam String address) {
        try {
            Student updatedStudent = new Student(name, age, phone, address);
            studentService.updateStudent(id, updatedStudent); // ID remains unchanged
            return "redirect:/students";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable String id) {
        try {
            studentService.deleteStudent(id);
            return "redirect:/students";
        } catch (Exception e) {
            return "error";
        }
    }
}