package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    List<Enrollment> enrollmentList = new ArrayList<>();
    StudentService ss;
    CourseService cs;

    public EnrollmentService(StudentService ss, CourseService cs) {
        this.ss = ss;
        this.cs = cs;
    }

    public String enrollStudentInCourse (int studentId, int courseId, String enrollmentDate) {
        Student student = ss.findStudentById(studentId);
        Course course = cs.findCourseById(courseId);

        Enrollment newEnrollment = new Enrollment(
                IdGenerator.getNextEnrollmentId(),
                studentId,
                courseId,
                enrollmentDate,
                EnrollmentStatus.ACTIVE
        );

        enrollmentList.add(newEnrollment);

        return "Student " + student.getFirstName() + " " + student.getLastName() + " has been enrolled into course " + course.getCourseName();
    }

    public List<Enrollment> viewStudentEnrollments (int studentId) {
        ss.findStudentById(studentId);

        List<Enrollment> res = new ArrayList<>();

        for (Enrollment e: enrollmentList) {
            if (studentId == e.getStudentId()) {
                res.add(e);
            }
        }
        return res;
    }

    public String markEnrollmentStatus (int id, int choice) {
        Enrollment enrollment = null;
        for (Enrollment e: enrollmentList) {
            if (e.getId() == id) {
                enrollment = e;
            }
        }

        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment " + id + " not found");
        }
        enrollment.setStatus(choice == 1 ? EnrollmentStatus.COMPLETED : EnrollmentStatus.CANCELLED);

        return "Enrollment status changed to " + enrollment.getStatus();
    }
}
