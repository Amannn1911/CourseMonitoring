package service;

import java.util.List;

import dao.CourseDao;
import dao.CourseDaoImpl;
import exception.CourseException;
import model.Course;

public class CourseServiceImpl implements CourseService {

    private CourseDao dao;

    public CourseServiceImpl() {
        this.dao = new CourseDaoImpl();
    }

    public String addCourse(Course course) throws CourseException {
       return dao.addCourse(course);

    }

    public Course getCourseById(int courseId) throws CourseException {
        return dao.getCourseById(courseId);
    }

    public List<Course> getAllCourses() throws CourseException {
        return dao.getAllCourses();
    }

    public String updateCourse(int courseId, Course course) throws CourseException {
        return dao.updateCourse(courseId, course);
    }


    public String deleteCourse(int courseId) throws CourseException {
        return dao.deleteCourse(courseId);
    }
}