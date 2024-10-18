package utility;

public class BatchQuery {
    public String insertBatch(){
        return  "INSERT INTO Batch(courseId, facultyId, numberOfStudents, batchStartDate, duration) VALUES(?, ?, ?, ?, ?)";
    }
    public String getBatchById(){
        return "SELECT * FROM Batch WHERE batchId = ?";
    }
    public String getAllBatches(){
        return "SELECT * FROM Batch";
    }

    public String allocateFacultyToBatch() {
        return "UPDATE Batch SET facultyId = ? WHERE batchId = ?";
    }

    public String updateBatch() {
     return "UPDATE Batch SET  courseId=?, facultyId=?, numberOfStudents=?, batchStartDate=?, duration=? WHERE batchId = ?";
    }

    public String deleteBatch() {
        return "DELETE FROM Batch WHERE batchId = ?";
    }
}