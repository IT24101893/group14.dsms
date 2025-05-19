package com.group14.dsms.library.model;

public class Instructor {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;
    private String specialization;

    // Default constructor
    public Instructor() {
    }

    // Constructor without ID (for new instructors)
    public Instructor(String name, int age, String phone, String address, String specialization) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.specialization = specialization;
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

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "Instructor{id=" + id + ", name='" + name + "', age=" + age +
                ", phone='" + phone + "', address='" + address + "', specialization='" + specialization + "'}";
    }
}