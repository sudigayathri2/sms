package edu.vnrvjiet.sms;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentMarkServiceRepository {

    HashMap<Integer, Student> idAndStudentHashMap = new HashMap<>();

    public Student add(Student student) {
        if (student != null && !idAndStudentHashMap.containsKey(student.getId())) {
            idAndStudentHashMap.put(student.getId(), student);
        }
        return student;
    }

    public List<Student> findAll() {
        return new ArrayList<>(idAndStudentHashMap.values());
    }

    public Student findById(Integer id) {
        Student student = null;
        if (id != null && idAndStudentHashMap.containsKey(id)) {
            student = idAndStudentHashMap.get(id);
        }
        return student;
    }

    public Student deleteById(Integer id) {
        Student student = null;
        if (id != null && idAndStudentHashMap.containsKey(id)) {
            student = idAndStudentHashMap.get(id);
            idAndStudentHashMap.remove(id);
        }
        return student;
    }

    public Student update(Student student) {
        Student existingStudent = null;
        if (student != null && idAndStudentHashMap.containsKey(student.getId())) {

            // Fetch existing
            existingStudent = idAndStudentHashMap.get(student.getId());

            // Update fields
            existingStudent.setName(student.getName());
            existingStudent.setTotalmarks(student.getTotalmarks());

            // Store updated student
            idAndStudentHashMap.put(student.getId(), existingStudent);
        }
        return existingStudent;
    }
}
