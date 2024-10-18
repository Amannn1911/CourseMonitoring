package usecases;

import java.util.List;
import java.util.Scanner;

import functionality.BatchFunctions;
import functionality.CourseFunctions;
import functionality.CoursePlanFunctions;
import functionality.FacultyFunctions;
import model.Admin;
import model.Batch;
import service.AdminService;
import service.AdminServiceImpl;
import service.BatchService;
import service.BatchServiceImpl;
import service.CoursePlanService;
import service.CoursePlanServiceImpl;

public class AdminMenu {
    private static Scanner sc = new Scanner(System.in);

    public void adminOperation() {
        AdminService adminService = new AdminServiceImpl();
        int choice;
        do{
            System.out.println("***** Admin Menu *****");
            System.out.println("1. Admin Register\n2. Admin Login\n0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Admin Registration");
                    System.out.print("Enter Username: ");
                    String newUsername = sc.next();
                    System.out.print("Enter Password: ");
                    String newPassword = sc.next();
                    Admin admin = new Admin(newUsername, newPassword);
                    System.out.println(adminService.addAdmin(admin));
                    break;
                case 2:
                    System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter PassWord: ");
                    String password = sc.next();

                    boolean valid = adminService.authenticate(username, password);
                    if (valid) {
                        System.out.println("Login successfully");
                        System.out.println();
                        int option;
                        do{
                            System.out.println("______Admin Options______");
                            System.out.println("1. Create, Update, View, Delete Course.\n" +
                                    "2. Create, Update, View, Delete Batch. \n" +
                                    "3. Create, Update, View, Delete Faculty.\n" +
                                    "4. Create, Update, View, Delete  Course Plan.\n" +
                                    "5. Allocate Faculty to a batch.\n" +
                                    "6. View the day wise update for every batch.\n" +
                                    "7. Generate Report for every batch\n" +
                                    "8. Update Password\n" +
                                    "0. Exit");
                            option = sc.nextInt();
                            BatchService batchService = new BatchServiceImpl();
                            switch (option) {
                                case 1:
                                    CourseFunctions cf = new CourseFunctions();
                                    cf.courseFunction();
                                    break;
                                case 2:
                                    BatchFunctions bf = new BatchFunctions();
                                    bf.batchFunction();
                                    break;
                                case 3:
                                    FacultyFunctions ff = new FacultyFunctions();
                                    ff.facultyFunction();
                                    break;
                                case 4:
                                    CoursePlanFunctions cpf = new CoursePlanFunctions();
                                    cpf.coursePlanFunction();
                                    break;
                                case 5:
                                    System.out.println("Allocate Faculty to a batch");
                                    System.out.print("Enter Faculty Id; ");
                                    int facultyId = sc.nextInt();
                                    System.out.print("Enter Batch Id: ");
                                    int batchId = sc.nextInt();
                                    System.out.println( batchService.allocateFacultyToBatch(facultyId, batchId));
                                    break;
                                case 6:
                                    CoursePlanService coursePlanService = new CoursePlanServiceImpl();
                                    System.out.print("Enter Batch Id: ");
                                    int id = sc.nextInt();
                                    boolean value = coursePlanService.viewDayWiseUpdate(id);
                                    if(!value) System.out.println("No data Found");
                                    break;
                                case 7:
                                    System.out.println("1. Generate Report for a batch\n2. Generate Report of all batches");
                                    int reportOpt = sc.nextInt();
                                    if (reportOpt == 1) {
                                        System.out.print("Enter Batch Id: ");
                                        Batch report = batchService.getBatchById(sc.nextInt());
                                        if(report!=null){
                                            System.out.println(report);
                                        } else{
                                            System.out.println("Report Not Found!");
                                        }
                                    } else if (reportOpt == 2) {
                                        List<Batch> batches = batchService.getAllBatches();
                                        for(Batch batch: batches){
                                            System.out.println(batch);
                                        }
                                    } else {
                                        System.out.println("Invalid Choice");
                                    }
                                    break;
                                case 8:
                                    System.out.print("Enter New Password: ");
                                    String updatedPassword = sc.next();
                                    System.out.println(adminService.updatePassword(username, updatedPassword));
                                    break;
                                case 0:
                                    System.out.println("Exiting...");
                                    break;
                                default:
                                    System.out.println("Invalid Choice");
                            }
                            System.out.println();
                        } while (option!=0);
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
        } while (choice!=0);
    }
}