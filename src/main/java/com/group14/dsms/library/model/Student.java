package com.group14.dsms.library.model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;

    // Default constructor
    public Student() {
    }

    // Constructor without ID (for new students where ID is auto-assigned)
    public Student(String name, int age, String phone, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // Override toString() method
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age +
                ", phone='" + phone + "', address='" + address + "'}";
    }
}