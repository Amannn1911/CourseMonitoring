package model;

public class Faculty {
    private int facultyId;
    private String facultyName;
    private String facultyAddress;
    private String mobileNo;
    private String email;
    private String username;
    private String password;

    public Faculty() {
    }

    public Faculty(String facultyName,String facultyAddress, String mobileNo, String email, String username, String password) {
        this.facultyName = facultyName;
        this.facultyAddress = facultyAddress;
        this.mobileNo = mobileNo;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyAddress() {
        return facultyAddress;
    }

    public void setFacultyAddress(String facultyAddress) {
        this.facultyAddress = facultyAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", address='" + facultyAddress + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}