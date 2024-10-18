package dao;

import java.util.List;

import exception.CourseException;
import model.Course;

public interface CourseDao {
    String addCourse(Course course) throws CourseException;
    Course getCourseById(int courseId) throws CourseException;
    List<Course> getAllCourses() throws CourseException;
    String updateCourse(int courseId, Course course) throws CourseException;
    String deleteCourse(int courseId) throws CourseException;
}