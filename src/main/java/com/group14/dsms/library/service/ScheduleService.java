package com.group14.dsms.library.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group14.dsms.library.model.*;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class ScheduleService {

    private final Path filePath = Path.of("src/main/resources/data/schedules.json");
    private static int lessonIdCounter = 1;
    private final FileStorageService<Schedule> fileStorageService;
    private final ObjectMapper objectMapper;

    public ScheduleService(FileStorageService<Schedule> fileStorageService) throws Exception {
        this.fileStorageService = fileStorageService;
        this.objectMapper = new ObjectMapper();
        initializeIdCounter();
    }

    private void initializeIdCounter() throws Exception {
        List<Schedule> schedules = getAllSchedules();
        if (!schedules.isEmpty()) {
            lessonIdCounter = schedules.stream()
                    .mapToInt(schedule -> Integer.parseInt(schedule.getLessonId().substring(1))) // Extract numeric part
                    .max()
                    .orElse(0) + 1;
        }
    }

    public List<Schedule> getAllSchedules() throws Exception {
        return fileStorageService.read(filePath, new TypeReference<>() {});
    }

    public void saveAllSchedules(List<Schedule> schedules) throws Exception {
        fileStorageService.write(filePath, schedules);
    }

    public void addSchedule(Schedule schedule) throws Exception {
        List<Schedule> schedules = getAllSchedules();
        schedule.setLessonId(String.format("L%03d", lessonIdCounter++)); // Generate ID like L001, L002, etc.
        schedules.add(schedule);
        saveAllSchedules(schedules);
    }

    public void updateSchedule(String lessonId, Schedule updatedSchedule) throws Exception {
        List<Schedule> schedules = getAllSchedules();
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getLessonId().equals(lessonId)) {
                updatedSchedule.setLessonId(lessonId);
                schedules.set(i, updatedSchedule);
                saveAllSchedules(schedules);
                return;
            }
        }
        throw new Exception("Schedule with Lesson ID " + lessonId + " not found.");
    }

    public void deleteSchedule(String lessonId) throws Exception {
        List<Schedule> schedules = getAllSchedules();
        boolean removed = schedules.removeIf(schedule -> schedule.getLessonId().equals(lessonId));
        if (removed) {
            saveAllSchedules(schedules);
        } else {
            throw new Exception("Schedule with Lesson ID " + lessonId + " not found.");
        }
    }
}