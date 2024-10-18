package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.FacultyException;
import model.Faculty;
import utility.ConnectionFactory;
import utility.FacultyQuery;


public class FacultyDaoImpl implements FacultyDao{
    FacultyQuery query = new FacultyQuery();
    public String addFaculty(Faculty faculty) throws FacultyException{
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.insertFaculty())){
            ps.setString(1, faculty.getFacultyName());
            ps.setString(2, faculty.getFacultyAddress());
            ps.setString(3, faculty.getMobileNo());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getUsername());
            ps.setString(6, faculty.getPassword());
            int x = ps.executeUpdate();
            if(x>0){
                return "Faculty Added Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Faculty getFacultyById(int facultyId) throws FacultyException{
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.getFacultyById())){
            ps.setInt(1, facultyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyId(rs.getInt("facultyId"));
                faculty.setFacultyName(rs.getString("facultyName"));
                faculty.setFacultyAddress(rs.getString("facultyAddress"));
                faculty.setMobileNo(rs.getString("mobileNo"));
                faculty.setEmail(rs.getString("email"));
                faculty.setUsername(rs.getString("username"));
                faculty.setPassword(rs.getString("password"));
                return faculty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Faculty> getAllFaculties() throws FacultyException {
        List<Faculty> faculties = new ArrayList<>();
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.getAllFaculties())){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyId(rs.getInt("facultyId"));
                faculty.setFacultyName(rs.getString("facultyName"));
                faculty.setFacultyAddress(rs.getString("facultyAddress"));
                faculty.setMobileNo(rs.getString("mobileNo"));
                faculty.setEmail(rs.getString("email"));
                faculty.setUsername(rs.getString("username"));
                faculty.setPassword(rs.getString("password"));
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    public boolean authenticate(String username, String password) throws FacultyException {
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.authenticate())){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String updatePassword(String username,String newPassword) throws FacultyException{
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.updatePassword())){
            ps.setString(1,newPassword);
            ps.setString(2,username);
            int x = ps.executeUpdate();
            if(x>0){
                return "Password Updated Successfully!";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String updateFaculty(int facultyId, Faculty faculty) throws FacultyException {
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.updateFaculty())){
            ps.setString(1, faculty.getFacultyName());
            ps.setString(2, faculty.getFacultyAddress());
            ps.setString(3, faculty.getMobileNo());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getUsername());
            ps.setString(6, faculty.getPassword());
            ps.setInt(7,facultyId);
            int x = ps.executeUpdate();
            if(x>0){
                return "Faculty updated successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteFaculty(int facultyId) throws FacultyException {
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.deleteFaculty())){
            ps.setInt(1,facultyId);
            int x = ps.executeUpdate();
            if(x>0){
                return "Faculty Deleted successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}