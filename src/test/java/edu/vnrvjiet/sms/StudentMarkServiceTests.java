package edu.vnrvjiet.sms;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentMarkServiceTests {

    @Autowired
    private StudentMarkService studentMarkService;

    @Test
    void contextLoads() {}

    // Add Student 1
    @Test
    @Order(1)
    public void addOneStudentTest_1() {
        Student student = new Student(1, "Satya", 297);  // totalMarks
        student = studentMarkService.addOneStudent(student);

        assertNotEquals(null, student);
        assertEquals(1, student.getId());
        assertEquals("Satya", student.getName());
        assertEquals(297, student.getTotalmarks());
    }

    // Add Student 2
    @Test
    @Order(2)
    public void addOneStudentTest_2() {
        Student student = new Student(2, "Dev", 300);
        student = studentMarkService.addOneStudent(student);

        assertNotEquals(null, student);
        assertEquals(2, student.getId());
        assertEquals("Dev", student.getName());
        assertEquals(300, student.getTotalmarks());
    }

    // Find All
    @Test
    @Order(3)
    public void findAllTest_1() {
        List<Student> students = studentMarkService.findAllStudents();

        assertEquals(2, students.size());
        assertEquals("Satya", students.get(0).getName());
        assertEquals("Dev", students.get(1).getName());
    }

    // Find by ID
    @Test
    @Order(4)
    public void findByIdTest() {
        Student student = studentMarkService.findById(1);

        assertNotEquals(null, student);
        assertEquals("Satya", student.getName());
        assertEquals(297, student.getTotalmarks());
    }

    // Delete by ID
    @Test
    @Order(5)
    public void deleteByIdTest() {
        Student student = studentMarkService.deleteById(2);

        assertNotEquals(null, student);
        assertEquals(2, student.getId());
        assertEquals("Dev", student.getName());
        assertEquals(300, student.getTotalmarks());
    }

    // Update existing student
    @Test
    @Order(6)
    public void updateStudentTest_1() {
        Student student = new Student(1, "Satya Dev", 300);
        student = studentMarkService.updateStudent(student);

        assertNotEquals(null, student);
        assertEquals(1, student.getId());
        assertEquals("Satya Dev", student.getName());
        assertEquals(300, student.getTotalmarks());
    }

    // Update non-existing → should return null
    @Test
    @Order(7)
    public void updateStudentTest_2() {
        Student student = new Student(2, "DevX", 250); // Already deleted earlier
        student = studentMarkService.updateStudent(student);

        assertEquals(null, student);
    }

    // Final findAll
    @Test
    @Order(8)
    public void findAllTest_2() {
        List<Student> students = studentMarkService.findAllStudents();

        assertEquals(1, students.size());

        Student student = students.get(0);
        assertEquals(1, student.getId());
        assertEquals("Satya Dev", student.getName());
        assertEquals(300, student.getTotalmarks());
    }
}
