package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    List<Course> coursesList = new ArrayList<>();

    private Course findById (int id) {

        for(Course c: coursesList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public String addCourse (String courseName, String description, int durationInWeeks) {
        Course newCourse = new Course(
                IdGenerator.getNextCourseId(),
                courseName, description,
                durationInWeeks,
                true
        );

        coursesList.add(newCourse);
        return "Course " + courseName + " " + "added";

    }

    public void removeCourse () {

    }

    public void updateCourse (Course course) {

    }

    public Course findCourseById (int id) {
        Course course = findById(id);

        if (course == null) {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }
        return course;
    }

    public void changeCourseStatus (int id) {
        Course courseToDeactivate = findCourseById(id);
        courseToDeactivate.setActive(!courseToDeactivate.isActive());
    }

    public List<Course> listCourses () {
        return coursesList;
    }
}
