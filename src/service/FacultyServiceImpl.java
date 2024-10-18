package service;

import java.util.List;

import dao.FacultyDao;
import dao.FacultyDaoImpl;
import exception.FacultyException;
import model.Faculty;

public class FacultyServiceImpl implements FacultyService {
    private FacultyDao dao;

    public FacultyServiceImpl() {
        this.dao = new FacultyDaoImpl();
    }

    public String addFaculty(Faculty faculty)  throws FacultyException {
        return dao.addFaculty(faculty);
    }

    public Faculty getFacultyById(int facultyId)throws FacultyException {
        return dao.getFacultyById(facultyId);
    }

    public List<Faculty> getAllFaculties() throws FacultyException {
        return dao.getAllFaculties();
    }
    public boolean authenticate(String username, String password) throws FacultyException{
        return dao.authenticate(username,password);
    }
    public String updatePassword(String username,String newPassword) throws FacultyException{
        return dao.updatePassword(username,newPassword);
    }

    public String updateFaculty(int facultyId, Faculty updatedFaculty) throws FacultyException {
        return dao.updateFaculty(facultyId,updatedFaculty);
    }

    public String deleteFaculty(int facultyId) throws FacultyException {
        return dao.deleteFaculty(facultyId);
    }
}