import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.List;
import java.util.Scanner;

import static com.airtribe.learntrack.util.InputValidator.parseIntInput;
import static com.airtribe.learntrack.util.InputValidator.parseStringInput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        StudentService ss = new StudentService();
        CourseService cs = new CourseService();
        EnrollmentService es = new EnrollmentService(ss, cs);

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("""
                1. Add a new student
                2. Display All students
                3. Search a student
                4. Deactivate a student
                5. Add a new course
                6. View a course
                7. Activate or Deactivate a course
                8. Enroll a student in a course
                9. View student enrollments
                10. Mark enrollment status
                11. Exit""");
            System.out.println("Choice: ");
            try {
                choice = parseIntInput(sc.nextLine(), "Choice");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Try again");
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter student's first name: ");
                        String firstName = parseStringInput(sc.nextLine(), "First name");
                        System.out.println("Enter student's last name: ");
                        String lastName = parseStringInput(sc.nextLine(), "Last name");
                        System.out.println("Enter student's email: ");
                        String email = parseStringInput(sc.nextLine(), "Email");
                        System.out.println("Enter student's batch: ");
                        String batch = parseStringInput(sc.nextLine(), "Batch");
                        System.out.println(ss.addStudent(firstName, lastName, email, batch));
                        break;
                    case 2:
                        List<Student> studentList = ss.listStudents();
                        if (studentList.isEmpty()) {
                            System.out.println("No students found");
                        } else {
                            for (Student i: ss.listStudents()) {
                                System.out.println(i);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter student id: ");
                        int searchId;
                        try {
                            searchId = parseIntInput(sc.nextLine(), "Student id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println(ss.findStudentById(searchId));
                        break;
                    case 4:
                        System.out.println("Enter student id to deactivate: ");
                        int deActivateStudentId;
                        try {
                            deActivateStudentId = parseIntInput(sc.nextLine(), "Student id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        ss.deactivateStudent(deActivateStudentId);
                        System.out.println("Student " + deActivateStudentId + " de activated");
                        break;
                    case 5:
                        System.out.println("Enter course name: ");
                        String courseName = parseStringInput(sc.nextLine(), "Course name");
                        System.out.println("Enter course description: ");
                        String description = parseStringInput(sc.nextLine(), "Description");
                        System.out.println("Enter course duration in weeks: ");
                        int duration;
                        try {
                            duration = parseIntInput(sc.nextLine(), "Duration in weeks");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println(cs.addCourse(courseName, description, duration));
                        break;
                    case 6:
                        List<Course> courseList = cs.listCourses();

                        if (courseList.isEmpty()) {
                            System.out.println("No courses found");
                        } else {
                            for (Course course: cs.listCourses()) {
                                System.out.println(course);
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Enter course id for status change: ");
                        int deActivateCourseId;
                        try {
                            deActivateCourseId = parseIntInput(sc.nextLine(), "Course Id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        cs.changeCourseStatus(deActivateCourseId);
                        System.out.println("Course " + deActivateCourseId + " status changed");
                        break;
                    case 8:
                        System.out.println("Enter student's id to be enrolled: ");
                        int studentId;
                        try {
                            studentId = parseIntInput(sc.nextLine(), "Student id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println("Enter course id to be enrolled in: ");
                        int courseId;
                        try {
                            courseId = parseIntInput(sc.nextLine(), "Course id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println("Enter enrollmentDate: ");
                        String date = parseStringInput(sc.nextLine(), "Enrollment date");
                        System.out.println(es.enrollStudentInCourse(studentId, courseId, date));
                        break;
                    case 9:
                        System.out.println("Enter student's id: ");
                        int studentIdEnrolled;
                        try {
                            studentIdEnrolled = parseIntInput(sc.nextLine(), "Student id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println(es.viewStudentEnrollments(studentIdEnrolled));
                        break;
                    case 10:
                        System.out.println("Enter the enrollment id to change status: ");
                        int enrollId;
                        try {
                            enrollId = parseIntInput(sc.nextLine(), "Enroll Id");
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again.");
                            break;
                        }
                        System.out.println("Choose status: 1.COMPLETED 2.CANCELLED");
                        int statusChoice;
                        try {
                            statusChoice = parseIntInput(sc.nextLine(), "Status choice");
                            if (statusChoice > 2) {
                                System.out.println("Wrong choice. Try again");
                                break;
                            }
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage() + " Try again.");
                            break;
                        }
                        System.out.println(es.markEnrollmentStatus(enrollId, statusChoice));
                        break;
                    case 11:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Wrong input. Try again");
                        break;
                }
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        } while (choice != 11);
    }


}