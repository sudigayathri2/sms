package edu.vnrvjiet.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {

    private Integer id;
    private String name;
    private Integer totalmarks;

    // Full constructo
    public Student(Integer id, String name, Integer totalmarks) {
        this.id = id;
        this.name = name;
        this.totalmarks = totalmarks;
    }

    // Default constructor


    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(Integer totalmarks) {
        this.totalmarks = totalmarks;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', totalmarks=" + totalmarks + "}";
    }
}
