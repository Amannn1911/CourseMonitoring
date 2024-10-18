package utility;

public class CourseQuery {
    public String insertCourse(){
        return "INSERT INTO Course(courseName, courseFee, courseDescription) VALUES(?, ?, ?)";
    }
    public String getCourseById(){
        return "SELECT * FROM Course WHERE courseId = ?";
    }
    public String getAllCourses(){
        return "SELECT * FROM Course";
    }
    public String updateCourse(){
        return "UPDATE Course SET courseName=?, courseFee=?,courseDescription=? WHERE courseId = ?";
    }

    public String deleteCourse() {
        return "DELETE FROM Course WHERE courseId = ?";
    }
}