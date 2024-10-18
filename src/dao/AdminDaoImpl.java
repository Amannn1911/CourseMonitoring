package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.AdminException;
import model.Admin;
import utility.AdminQuery;
import utility.ConnectionFactory;

public class AdminDaoImpl implements AdminDao{
	   AdminQuery query = new AdminQuery();

	    public String addAdmin(Admin admin) throws AdminException{
	        try(Connection con = ConnectionFactory.getInstance().getConnection();
	            PreparedStatement ps = con.prepareStatement(query.insertAdmin())) {
	            ps.setString(1, admin.getUsername());
	            ps.setString(2, admin.getPassword());
	            int x = ps.executeUpdate();
	            if(x>0){
	                return "Admin Registered Successfully! Now you can login to your account.";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    public boolean authenticate(String username, String password) throws AdminException {
	        try(Connection con = ConnectionFactory.getInstance().getConnection();
	            PreparedStatement ps = con.prepareStatement(query.selectAdmin())) {
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public String updatePassword(String username, String newPassword) throws AdminException {
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
	}