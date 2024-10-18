package service;

import java.util.List;

import dao.CoursePlanDao;
import dao.CoursePlanDaoImpl;
import exception.CourseException;
import exception.CoursePlanException;
import model.CoursePlan;

public class CoursePlanServiceImpl implements CoursePlanService{
    private CoursePlanDao dao;

    public CoursePlanServiceImpl() {
        this.dao = new CoursePlanDaoImpl();
    }

    public String addCoursePlan(CoursePlan coursePlan) throws CoursePlanException {
        return dao.addCoursePlan(coursePlan);
    }

    public List<CoursePlan> getCoursePlanByBatchId(int batchId) throws CoursePlanException {
        return dao.getCoursePlanByBatchId(batchId);
    }

    public boolean viewDayWiseUpdate(int batchId) throws CoursePlanException {
        return dao.viewDayWiseUpdate(batchId);
    }

    public String updateCoursePlan(int planId, CoursePlan updatedCoursePlan) throws CourseException {
        return dao.updateCoursePlan(planId,updatedCoursePlan);
    }

    @Override
    public String deleteCoursePlan(int planId) throws CourseException {
        return dao.deleteCoursePlan(planId);
    }
}
