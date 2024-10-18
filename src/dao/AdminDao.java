package dao;

import exception.AdminException;
import model.Admin;

public interface AdminDao {
    String addAdmin(Admin admin) throws AdminException;

    boolean authenticate(String username, String password) throws AdminException;

    String updatePassword(String username, String newPassword) throws AdminException;


}