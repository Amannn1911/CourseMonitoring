package model;

public class Course {
    private int courseId;
    private String courseName;
    private double courseFee;
    private String courseDescription;

    public Course() {
    }

    public Course(String courseName, double courseFee, String courseDescription) {
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.courseDescription = courseDescription;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}