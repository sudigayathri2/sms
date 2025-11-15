package edu.vnrvjiet.sms;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer totalmarks;


    public Integer getId() {
        return id;
    }
    public void setName(Object name) {

    }
    public Integer getTotalmarks() {
        return totalmarks;
    }

    public Object getName() {
    return name;}
}