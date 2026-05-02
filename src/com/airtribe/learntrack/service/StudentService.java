package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<Student> studentList = new ArrayList<>();

    private Student findById (int id) {

        for (Student s: studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public String addStudent (String firstName, String lastName, String email, String batch) {
        Student newStudent = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                email,
                batch,
                true);
        studentList.add(newStudent);
        return "Student " + firstName + " " + lastName + " added";
    }

    public void removeStudent (int id) {
        studentList.remove(findStudentById(id));
    }

    public void updateStudent (int id) {
    }

    public void deactivateStudent (int id) {
        Student student = findStudentById(id);
        student.setActive(false);
    }

    public Student findStudentById (int id) {
        Student student = findById(id);

        if (student == null) {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
        return student;
    }

    public List<Student> listStudents () {
        return !studentList.isEmpty() ? studentList : new ArrayList<>();
    }
}
