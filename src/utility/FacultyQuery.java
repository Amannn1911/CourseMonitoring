package utility;

public class FacultyQuery {
    public String insertFaculty(){
        return "INSERT INTO Faculty(facultyName, facultyAddress, mobileNo, email, username, password) VALUES(?, ?, ?, ?, ?, ?)";
    }
    public String getFacultyById(){
        return "SELECT * FROM Faculty WHERE facultyId = ?";
    }
    public String getAllFaculties(){
        return "SELECT * FROM Faculty";
    }
    public String authenticate(){
        return "SELECT * FROM Faculty WHERE username = ? AND password = ?";
    }

    public String updatePassword(){
        return "UPDATE Faculty SET password = ? WHERE username = ?";
    }

    public String updateFaculty() {
        return "UPDATE Faculty SET facultyName=?, facultyAddress=?, mobileNo=?, email=?, username=?, password=? WHERE facultyId=?";
    }
    public String deleteFaculty() {
        return "DELETE FROM Faculty WHERE facultyId = ?";
    }
}