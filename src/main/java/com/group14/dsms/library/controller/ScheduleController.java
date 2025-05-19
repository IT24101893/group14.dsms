package com.group14.dsms.library.controller;

import com.group14.dsms.library.model.*;
import com.group14.dsms.library.service.ScheduleService;
import com.group14.dsms.library.service.StudentService;
import com.group14.dsms.library.service.InstructorService;
import com.group14.dsms.library.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final VehicleService vehicleService;

    public ScheduleController(ScheduleService scheduleService, StudentService studentService,
                              InstructorService instructorService, VehicleService vehicleService) {
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String listSchedules(Model model) {
        try {
            List<Schedule> schedules = scheduleService.getAllSchedules();
            model.addAttribute("schedules", schedules);
            return "schedules";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            model.addAttribute("error", "Error retrieving schedule data: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/add-schedule")
    public String showAddScheduleForm(Model model) {
        try {
            List<Student> students = studentService.getAllStudents();
            List<Instructor> instructors = instructorService.getAllInstructors();
            List<Vehicle> vehicles = vehicleService.getAllVehicles();

            model.addAttribute("students", students);
            model.addAttribute("instructors", instructors);
            model.addAttribute("vehicles", vehicles);

            return "add-schedule";
        } catch (Exception e) {
            model.addAttribute("error", "Error loading data for schedule creation.");
            return "error";
        }
    }

    @PostMapping("/add-schedule")
    public String addSchedule(@RequestParam String type, @RequestParam String dateTime, @RequestParam int duration,
                              @RequestParam String status, @RequestParam String studentId,
                              @RequestParam String instructorId, @RequestParam String vehicleId, Model model) {
        try {
            // Validate IDs
            if (studentService.getStudentById(studentId) == null) {
                model.addAttribute("error", "Invalid Student ID.");
                return "error";
            }
            if (instructorService.getInstructorById(instructorId) == null) {
                model.addAttribute("error", "Invalid Instructor ID.");
                return "error";
            }
            if (vehicleService.getVehicleById(vehicleId) == null) {
                model.addAttribute("error", "Invalid Vehicle ID.");
                return "error";
            }

            // Create the appropriate subclass
            Schedule schedule;
            switch (type) {
                case "DrivingLessonSchedule":
                    schedule = new DrivingLessonSchedule();
                    break;
                case "TheoryLessonSchedule":
                    schedule = new TheoryLessonSchedule();
                    break;
                case "ExamSchedule":
                    schedule = new ExamSchedule();
                    break;
                default:
                    model.addAttribute("error", "Invalid schedule type.");
                    return "error";
            }

            // Set common properties
            schedule.setDateTime(LocalDateTime.parse(dateTime));
            schedule.setDuration(duration);
            schedule.setStatus(status);
            schedule.setStudentId(studentId);
            schedule.setInstructorId(instructorId);
            schedule.setVehicleId(vehicleId);

            scheduleService.addSchedule(schedule);
            return "redirect:/schedules";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            model.addAttribute("error", "Error adding schedule: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/edit-schedule/{lessonId}")
    public String showEditScheduleForm(@PathVariable String lessonId, Model model) {
        try {
            Schedule schedule = scheduleService.getAllSchedules().stream()
                    .filter(s -> s.getLessonId().equals(lessonId))
                    .findFirst()
                    .orElse(null);

            if (schedule == null) {
                model.addAttribute("error", "Schedule not found.");
                return "error";
            }

            model.addAttribute("schedule", schedule);

            List<Student> students = studentService.getAllStudents();
            List<Instructor> instructors = instructorService.getAllInstructors();
            List<Vehicle> vehicles = vehicleService.getAllVehicles();

            model.addAttribute("students", students);
            model.addAttribute("instructors", instructors);
            model.addAttribute("vehicles", vehicles);

            return "edit-schedule";
        } catch (Exception e) {
            model.addAttribute("error", "Error loading schedule data.");
            return "error";
        }
    }

    @PostMapping("/edit-schedule/{lessonId}")
    public String editSchedule(@PathVariable String lessonId, @RequestParam String type, @RequestParam String dateTime,
                               @RequestParam int duration, @RequestParam String status,
                               @RequestParam String studentId, @RequestParam String instructorId,
                               @RequestParam String vehicleId, Model model) {
        try {
            // Create the appropriate subclass
            Schedule updatedSchedule;
            switch (type) {
                case "DrivingLessonSchedule":
                    updatedSchedule = new DrivingLessonSchedule();
                    break;
                case "TheoryLessonSchedule":
                    updatedSchedule = new TheoryLessonSchedule();
                    break;
                case "ExamSchedule":
                    updatedSchedule = new ExamSchedule();
                    break;
                default:
                    model.addAttribute("error", "Invalid schedule type.");
                    return "error";
            }

            // Set common properties
            updatedSchedule.setDateTime(LocalDateTime.parse(dateTime));
            updatedSchedule.setDuration(duration);
            updatedSchedule.setStatus(status);
            updatedSchedule.setStudentId(String.valueOf(studentId));
            updatedSchedule.setInstructorId(String.valueOf(instructorId));
            updatedSchedule.setVehicleId(String.valueOf(vehicleId));

            scheduleService.updateSchedule(String.valueOf(lessonId), updatedSchedule);
            return "redirect:/schedules";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating schedule: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete-schedule/{lessonId}")
    public String deleteSchedule(@PathVariable String lessonId) {
        try {
            scheduleService.deleteSchedule(String.valueOf(lessonId));
            return "redirect:/schedules";
        } catch (Exception e) {
            return "error";
        }
    }
}