package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.CourseException;
import exception.CoursePlanException;
import model.CoursePlan;
import utility.ConnectionFactory;
import utility.CoursePlanQuery;

public class CoursePlanDaoImpl implements CoursePlanDao {
    CoursePlanQuery query = new CoursePlanQuery();

    public String addCoursePlan(CoursePlan coursePlan) throws CoursePlanException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertCoursePlan())) {
            ps.setInt(1, coursePlan.getBatchId());
            ps.setInt(2, coursePlan.getDayNumber());
            ps.setString(3, coursePlan.getTopic());
            ps.setString(4, coursePlan.getStatus());
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Plan Added Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CoursePlan> getCoursePlanByBatchId(int batchId) throws CoursePlanException {
        List<CoursePlan> coursePlans = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getCoursePlanByBatchId())) {
            ps.setInt(1, batchId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CoursePlan coursePlan = new CoursePlan();
                coursePlan.setPlanId(rs.getInt("planId"));
                coursePlan.setBatchId(rs.getInt("batchId"));
                coursePlan.setDayNumber(rs.getInt("dayNumber"));
                coursePlan.setTopic(rs.getString("topic"));
                coursePlan.setStatus(rs.getString("status"));
                coursePlans.add(coursePlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursePlans;
    }

    public boolean viewDayWiseUpdate(int batchId) throws CoursePlanException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.viewDayWIseUpdate())) {
            ps.setInt(1, batchId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dayNumber = rs.getInt("dayNumber");
                String topic = rs.getString("topic");
                String status = rs.getString("status");
                System.out.printf("%-11d | %-30s | %-10s%n", dayNumber, topic, status);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String updateCoursePlan(int planId, CoursePlan coursePlan) throws CourseException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.updatedCoursePlan())) {
            ps.setInt(1, coursePlan.getBatchId());
            ps.setInt(2, coursePlan.getDayNumber());
            ps.setString(3, coursePlan.getTopic());
            ps.setString(4, coursePlan.getStatus());
            ps.setInt(5, planId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Plan Updated Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteCoursePlan(int planId) throws CoursePlanException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.deleteCoursePlan())) {
            ps.setInt(1, planId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Course Plan Deleted Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}