package service;

import java.util.List;

import exception.FacultyException;
import model.Faculty;

public interface FacultyService {

    String addFaculty(Faculty faculty) throws FacultyException;
    Faculty getFacultyById(int facultyId) throws FacultyException;
    List<Faculty> getAllFaculties() throws FacultyException;
    boolean authenticate(String username, String password) throws FacultyException;
    String updatePassword(String username,String newPassword) throws FacultyException;

    String updateFaculty(int facultyId, Faculty updatedFaculty) throws FacultyException;

    String deleteFaculty(int facultyId) throws FacultyException;
}