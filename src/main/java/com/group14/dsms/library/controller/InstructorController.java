package com.group14.dsms.library.controller;

import com.group14.dsms.library.model.Instructor;
import com.group14.dsms.library.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String listInstructors(Model model) {
        try {
            List<Instructor> instructors = instructorService.getAllInstructors();
            model.addAttribute("instructors", instructors);
            return "instructors";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving instructor data.");
            return "error";
        }
    }

    @GetMapping("/add-instructor")
    public String showAddInstructorForm() {
        return "add-instructor";
    }

    @PostMapping("/add-instructor")
    public String addInstructor(@RequestParam String name, @RequestParam int age,
                                @RequestParam String phone, @RequestParam String address,
                                @RequestParam String specialization) {
        try {
            Instructor instructor = new Instructor(name, age, phone, address, specialization);
            instructorService.addInstructor(instructor);
            return "redirect:/instructors";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/edit-instructor/{id}")
    public String showEditInstructorForm(@PathVariable String id, Model model) {
        try {
            List<Instructor> instructors = instructorService.getAllInstructors();
            for (Instructor instructor : instructors) {
                if (instructor.getId().equals(id)) {
                    model.addAttribute("instructor", instructor);
                    return "edit-instructor";
                }
            }
            return "error";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/edit-instructor/{id}")
    public String editInstructor(@PathVariable String id, @RequestParam String name, @RequestParam int age,
                                 @RequestParam String phone, @RequestParam String address,
                                 @RequestParam String specialization) {
        try {
            Instructor updatedInstructor = new Instructor(name, age, phone, address, specialization);
            instructorService.updateInstructor(id, updatedInstructor);
            return "redirect:/instructors";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/delete-instructor/{id}")
    public String deleteInstructor(@PathVariable String id) {
        try {
            instructorService.deleteInstructor(id);
            return "redirect:/instructors";
        } catch (Exception e) {
            return "error";
        }
    }
}