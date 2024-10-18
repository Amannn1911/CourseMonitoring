package dao;

import java.util.List;

import exception.CourseException;
import exception.CoursePlanException;
import model.CoursePlan;

public interface CoursePlanDao {
	public String addCoursePlan(CoursePlan coursePlan) throws CoursePlanException;
    List<CoursePlan> getCoursePlanByBatchId(int batchId) throws CoursePlanException;
    boolean viewDayWiseUpdate(int batchId) throws CoursePlanException;

    String updateCoursePlan(int planId, CoursePlan updatedCoursePlan) throws CourseException;

    String deleteCoursePlan(int planId) throws CoursePlanException;
}