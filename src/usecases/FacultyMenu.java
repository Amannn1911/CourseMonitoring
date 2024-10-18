package usecases;

import java.util.List;
import java.util.Scanner;

import model.CoursePlan;
import service.FacultyService;
import service.FacultyServiceImpl;
import service.CoursePlanService;
import service.CoursePlanServiceImpl;

public class FacultyMenu {
    private static Scanner sc = new Scanner(System.in);

    public void facultyOperation() {
        FacultyService facultyService = new FacultyServiceImpl();
        int choice;
        do {
            System.out.println("***** Faculty Menu *****");
            System.out.println("1. Faculty Register\n2. Faculty Login\n0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Contact to your Admin");
                    break;
                case 2:
                    System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter Password: ");
                    String password = sc.next();

                    boolean valid = facultyService.authenticate(username, password);
                    if (valid) {
                        System.out.println("Login successfully");
                        System.out.println();
                        int option;
                        do {
                            System.out.println("______Faculty Options______");
                            System.out.println("1. View Course Plan\n2. Fill day wise planner\n3. Update  Password\n0. Exit");
                            option = sc.nextInt();
                            CoursePlanService coursePlanService = new CoursePlanServiceImpl();
                            switch (option) {
                                case 1:
                                    System.out.println("View Course PLan");
                                    System.out.print("Enter Batch Id:");
                                    List<CoursePlan> plans = coursePlanService.getCoursePlanByBatchId(sc.nextInt());
                                    if(plans.isEmpty()){
                                        System.out.println("No Course Plan Found");
                                    } else{
                                        for (CoursePlan plan : plans) {
                                            System.out.println(plan);
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter Batch Id: ");
                                    int batchId = sc.nextInt();
                                    System.out.print("Enter day Number: ");
                                    int dayNumber = sc.nextInt();
                                    System.out.print("Enter Topic Name: ");
                                    sc.nextLine();
                                    String topic = sc.nextLine();
                                    System.out.print("Enter Course Status(completed/pending): ");
                                    String status = sc.next();
                                    CoursePlan coursePlan = new CoursePlan(batchId, dayNumber, topic, status);
                                    System.out.println(coursePlanService.addCoursePlan(coursePlan));
                                    break;
                                case 3:
                                    System.out.print("Enter New Password: ");
                                    String newPassword = sc.next();
                                    System.out.println(facultyService.updatePassword(username, newPassword));
                                    break;
                                case 0:
                                    System.out.println("Exiting...");
                                    break;
                                default:
                                    System.out.println("Invalid Choice.");
                            }
                            System.out.println();
                        } while (option != 0);
                    } else {
                        System.out.println("Not valid username or password");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again...");
            }
            System.out.println();
        } while (choice != 0);
    }
}