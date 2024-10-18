package functionality;

import java.util.List;
import java.util.Scanner;

import model.Course;
import service.CourseService;
import service.CourseServiceImpl;

public class CourseFunctions {
    private static Scanner sc = new Scanner(System.in);

    public void courseFunction() {
        CourseService courseService = new CourseServiceImpl();
        int option;
        do {
            System.out.println("_____Courser Portal_____");
            System.out.println("1. Create Course\n2. Update Course\n3. View Course\n4. Delete Course\n0. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter Course Name: ");
                    sc.nextLine();
                    String courseName = sc.nextLine();
                    System.out.print("Enter Course Fee: ");
                    double courseFee = sc.nextDouble();
                    System.out.print("Enter Course Description: ");
                    sc.nextLine();
                    String courseDesc = sc.nextLine();
                    Course course = new Course(courseName, courseFee, courseDesc);
                    System.out.println(courseService.addCourse(course));
                    break;
                case 2:
                    System.out.print("Enter CourseId: ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Updated Course Name: ");
                    sc.nextLine();
                    String updatedCourseName = sc.nextLine();
                    System.out.print("Enter Updated Course Fee: ");
                    double updatedCourseFee = sc.nextDouble();
                    System.out.print("Enter Updated Course Description: ");
                    sc.nextLine();
                    String updatedCourseDesc = sc.nextLine();
                    Course updatedCourse = new Course(updatedCourseName, updatedCourseFee, updatedCourseDesc);
                    System.out.println(courseService.updateCourse(courseId, updatedCourse));
                    break;
                case 3:
                    System.out.println("1. View Course by course Id\n2. View All Courses");
                    int viewCourse = sc.nextInt();
                    if (viewCourse == 1) {
                        System.out.print("Enter Course Id: ");
                        Course courseView = courseService.getCourseById(sc.nextInt());
                        if (courseView != null) {
                            System.out.println(courseView);
                        } else {
                            System.out.println("No Course Found.");
                        }
                    } else if (viewCourse == 2) {
                        List<Course> courses = courseService.getAllCourses();
                        if (courses.isEmpty()) {
                            System.out.println("No Courses Found");
                        } else {
                            for (Course course1 : courses) {
                                System.out.println(course1);
                            }
                        }
                    } else {
                        System.out.println("Invalid Choice");
                    }
                    break;
                case 4:
                    System.out.print("Enter Course Id you want to delete: ");
                    System.out.println(courseService.deleteCourse(sc.nextInt()));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println();
        } while (option != 0);
    }
}