package com.group14.dsms.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown fields during deserialization
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "scheduleType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DrivingLessonSchedule.class, name = "DrivingLesson"),
        @JsonSubTypes.Type(value = TheoryLessonSchedule.class, name = "TheoryLesson"),
        @JsonSubTypes.Type(value = ExamSchedule.class, name = "Exam")
})
public abstract class Schedule {
    private String lessonId;
    private LocalDateTime dateTime;
    private int duration;
    private String status;
    private String studentId;
    private String instructorId;
    private String vehicleId;

    // Getters and setters
    public String getLessonId() { return lessonId; }
    public void setLessonId(String lessonId) { this.lessonId = lessonId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        return dateTime.format(formatter);
    }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getInstructorId() { return instructorId; }
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    // Abstract method for polymorphism
    public abstract String getScheduleType();
}