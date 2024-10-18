package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.CourseException;
import model.Course;
import utility.ConnectionFactory;
import utility.CourseQuery;


public class CourseDaoImpl implements CourseDao {
    CourseQuery query = new CourseQuery();

    public String addCourse(Course course) throws CourseException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertCourse())) {
            ps.setString(1, course.getCourseName());
            ps.setDouble(2, course.getCourseFee());
            ps.setString(3, course.getCourseDescription());
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Added Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Course getCourseById(int courseId) throws CourseException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getCourseById())) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseFee(rs.getDouble("courseFee"));
                course.setCourseDescription(rs.getString("courseDescription"));
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> getAllCourses() throws CourseException {
        List<Course> courses = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getAllCourses())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseFee(rs.getDouble("courseFee"));
                course.setCourseDescription(rs.getString("courseDescription"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public String updateCourse(int courseId, Course course) throws CourseException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.updateCourse())) {
            ps.setString(1, course.getCourseName());
            ps.setDouble(2, course.getCourseFee());
            ps.setString(3, course.getCourseDescription());
            ps.setInt(4, courseId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Updated Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteCourse(int courseId) throws CourseException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.deleteCourse())) {
            ps.setInt(1, courseId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Deleted Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
