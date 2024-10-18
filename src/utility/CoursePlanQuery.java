package utility;

public class CoursePlanQuery {
    public String insertCoursePlan(){
        return "INSERT INTO CoursePlan(batchId, dayNumber, topic, status) VALUES(?, ?, ?, ?)";
    }
    public String getCoursePlanByBatchId(){
        return "SELECT * FROM CoursePlan WHERE batchId = ?";
    }

    public String viewDayWIseUpdate(){
        return "SELECT cp.dayNumber, cp.topic, cp.status FROM CoursePlan cp JOIN Batch b ON cp.batchId = b.batchId WHERE b.batchId = ?";
    }

    public String updatedCoursePlan() {
        return "UPDATE CoursePlan SET batchId=?, dayNumber=?, topic=?, status=? WHERE planId=?";
    }

    public String deleteCoursePlan() {
        return "DELETE FROM CoursePlan WHERE planId = ?";
    }
}