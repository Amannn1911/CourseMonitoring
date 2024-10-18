package functionality;

import java.util.List;
import java.util.Scanner;
import service.CoursePlanService;
import service.CoursePlanServiceImpl;

import model.CoursePlan;

public class CoursePlanFunctions {
    private static Scanner sc = new Scanner(System.in);

    public void coursePlanFunction() {
        CoursePlanService coursePlanService = new CoursePlanServiceImpl();
        int option;
        do {
            System.out.println("_____Course Plan Portal_____");
            System.out.println("1. Create Course Plan\n2. Update Course Plan\n3. View Course Plan\n4. Delete Course Plan\n0. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter Batch Id: ");
                    int batchId = sc.nextInt();
                    System.out.print("Enter day Number: ");
                    int dayNumber = sc.nextInt();
                    System.out.print("Enter Topic: ");
                    sc.nextLine();
                    String topic = sc.nextLine();
                    System.out.print("Enter Status(completed/pending): ");
                    String status = sc.next();
                    CoursePlan coursePlan = new CoursePlan(batchId, dayNumber, topic, status);
                    System.out.println(coursePlanService.addCoursePlan(coursePlan));
                    break;
                case 2:
                    System.out.print("Enter planId: ");
                    int planId = sc.nextInt();
                    System.out.print("Enter Updated Batch Id: ");
                    int updatedBatchId = sc.nextInt();
                    System.out.print("Enter Updated day Number: ");
                    int updatedUayNumber = sc.nextInt();
                    System.out.print("Enter Updated Topic: ");
                    sc.nextLine();
                    String updatedTopic = sc.nextLine();
                    System.out.print("Enter Updated Status(completed/pending): ");
                    String updatedStatus = sc.next();
                    CoursePlan updatedCoursePlan = new CoursePlan(updatedBatchId, updatedUayNumber, updatedTopic, updatedStatus);
                    System.out.println(coursePlanService.updateCoursePlan(planId, updatedCoursePlan));
                    break;
                case 3:
                    System.out.print("Enter Batch Id: ");
                    List<CoursePlan> coursePlanList = coursePlanService.getCoursePlanByBatchId(sc.nextInt());
                    if (coursePlanList.isEmpty()) {
                        System.out.println("No Course Plan Found");
                    } else {
                        for (CoursePlan coursePlan1 : coursePlanList) {
                            System.out.println(coursePlan1);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter planId of Course Plan you want to delete: ");
                    System.out.println(coursePlanService.deleteCoursePlan(sc.nextInt()));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println();
        } while (option != 0);
    }
}