package model;

import java.sql.Date;

public class Batch {
    private int batchId;
    private int courseId;
    private int facultyId;
    private int numberOfStudents;
    private Date batchStartDate;
    private int duration;

    public Batch(int courseId,int facultyId,int numberOfStudents,Date batchStartDate,int duration) {
        this.courseId = courseId;
        this.facultyId = facultyId;
        this.numberOfStudents = numberOfStudents;
        this.batchStartDate = batchStartDate;
        this.duration = duration;
    }

    public Batch() {
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Date getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", courseId=" + courseId +
                ", facultyId=" + facultyId +
                ", numberOfStudents=" + numberOfStudents +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", duration=" + duration +
                '}';
    }
}