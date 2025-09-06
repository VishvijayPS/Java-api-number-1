package com.example.demo_api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo_api.model.Student;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long nextId = 1L;

    // Add student
    public Student addStudent(Student student) {
        student.setId(nextId++);
        students.put(student.getId(), student);
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    // Update student
    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        if (students.containsKey(id)) {
            updatedStudent.setId(id);
            students.put(id, updatedStudent);
            return Optional.of(updatedStudent);
        }
        return Optional.empty();
    }

    // Delete student
    public boolean deleteStudent(Long id) {
        return students.remove(id) != null;
    }
}
