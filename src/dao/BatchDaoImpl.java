package dao;

import java.sql.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.BatchException;
import model.Batch;
import utility.BatchQuery;
import utility.ConnectionFactory;

public class BatchDaoImpl implements BatchDao {
    BatchQuery query = new BatchQuery();

    public String addBatch(Batch batch) throws BatchException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertBatch())) {
            ps.setInt(1, batch.getCourseId());
            ps.setInt(2, batch.getFacultyId());
            ps.setInt(3, batch.getNumberOfStudents());
            ps.setDate(4, (Date) batch.getBatchStartDate());
            ps.setInt(5, batch.getDuration());
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Batch Added Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Batch getBatchById(int batchId) throws BatchException {
        Batch batch = new Batch();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getBatchById())) {
            ps.setInt(1, batchId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                batch.setBatchId(rs.getInt("batchId"));
                batch.setCourseId(rs.getInt("courseId"));
                batch.setFacultyId(rs.getInt("facultyId"));
                batch.setNumberOfStudents(rs.getInt("numberOfStudents"));
                batch.setBatchStartDate(rs.getDate("batchStartDate"));
                batch.setDuration(rs.getInt("duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batch;
    }

    public List<Batch> getAllBatches() throws BatchException {
        List<Batch> batches = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getAllBatches())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Batch batch = new Batch();
                batch.setBatchId(rs.getInt("batchId"));
                batch.setCourseId(rs.getInt("courseId"));
                batch.setFacultyId(rs.getInt("facultyId"));
                batch.setNumberOfStudents(rs.getInt("numberOfStudents"));
                batch.setBatchStartDate(rs.getDate("batchStartDate"));
                batch.setDuration(rs.getInt("duration"));
                batches.add(batch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batches;
    }

    public String allocateFacultyToBatch(int facultyId, int batchId) throws BatchException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.allocateFacultyToBatch())) {
            ps.setInt(1, facultyId);
            ps.setInt(2, batchId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Faculty allocated to batch successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String updateBatch(int batchId, Batch batch) throws BatchException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.updateBatch())) {
            ps.setInt(1, batch.getCourseId());
            ps.setInt(2, batch.getFacultyId());
            ps.setInt(3, batch.getNumberOfStudents());
            ps.setDate(4, (Date) batch.getBatchStartDate());
            ps.setInt(5, batch.getDuration());
            ps.setInt(6, batchId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Batch Updated Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteBatch(int batchId) throws BatchException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.deleteBatch())) {
            ps.setInt(1, batchId);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Batch Deleted Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}