/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
import java.util.ArrayList;
import java.util.Scanner;

public class CECS343Team4 {

    private static Scanner sc1 = new Scanner(System.in);
    private static final int ADMIN_ID_LIMIT = 500000000;
    private static final int STUDENT_ID_LIMIT = 999999999;

    private static int adminIDIncrement = 1;
    private static int studentIDIncrement = 500000001;

    private static Database_Control dbc = new Database_Control();
    private static Database db = new Database();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int loginput = 0;

        String password = "";
        //String formatID = "";

       // ArrayList<Integer> adminIDs = new ArrayList<>();




        // 3 possible interfaces
        /*
         * one for superuser
         * one for admin
         * one for student
         */
        do {

            System.out.println("Enter user ID. Enter a negative to terminate");

            try {
                loginput = sc.nextInt();
                // terminate program if negative value is inputted
                if (loginput < 0) {
                    return;
                }

                // check if ID is superuser, admin, student, or invalid
                if (loginput == 0) {
                    System.out.println("Enter password to gain super user priviledge.");

                    sc.nextLine();
                    password = sc.nextLine();

                    // check if password matches
                    if (password.compareTo("abcd") == 0) {
                        System.out.println("Welcome super user.");

                        //display admin menu
                        superUserMenuDisplay();

                    } else {
                        System.out.println("Invalid password returning to main login");
                    }

                } else if (loginput > 0 && loginput <= ADMIN_ID_LIMIT) {
                    System.out.println("Welcome admin");

                    //create admin menu
                    //adminMenuDisplay();

                } else if (loginput > ADMIN_ID_LIMIT && loginput <= STUDENT_ID_LIMIT) {
                    System.out.println("Welcome student");

                    // create student menu
                    //studentMenuDisplay();
                } else {
                    System.out.println("Invalid id recognized\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input\n");
                sc.next();

            }
        } while (loginput >= 0);

    }

    /*
    Edit or delete:
        options - College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back
    */

    public static void superUserMenuDisplay() {

        //Objects
        College college;
        Department department;
        Major major;
        Course course;
        Employee emp;
       // Student stu;

       // user input variables
        String employeeName = "";
        String collegeName = "";
        String departmentName = "";
        String majorName = "";
        String courseName = "";
        String studentName = "";
        float employeeSalary = 0;
        int employeeID = 0;
        int deanID = 0;
        int chairID = 0;
        int optionSelect = 0;
        int units = 0;



        do {
            System.out.println("\nSuperUser Priviledges \n1. Add Employee \n2. Add College \n3. Add Department \n4. Add Major \n5. Add Courses \n6. Add Student \n7. Edit \n8. Delete \n9. Back");

            try {

                optionSelect = sc1.nextInt();

                switch (optionSelect) {
                    case 1:
                    //for setting an Admin
                        Database_Control dbc = new Database_Control();
                        System.out.println("Enter the ID of the Employee you want to assign as Admin");
                        int id = sc1.nextInt();
                        dbc.getEmployee(db, id).setAdmin(true);



                        //for adding an Employee
                        sc1.nextLine();
                        System.out.println("Enter the employees name");
                        employeeName = sc1.nextLine();

                        System.out.println("Enter the employees ID");
                        employeeID = sc1.nextInt();


                        System.out.println("Enter in the employees salary");
                        employeeSalary = sc1.nextFloat();

                        emp = new Employee(employeeName,employeeID,employeeSalary);

                        /*
                        Logic to put into database
                        */


                        break;

                    case 2:
                        sc1.nextLine();
                        System.out.println("Enter college name");

                        //character limit checking for college name
                        do {
                            collegeName = sc1.nextLine();
                            if (collegeName.length() > 60) {
                                System.out.println("Too many characters in college name");
                            }

                        } while (collegeName.length() > 60);

                        System.out.println("Enter deanID for this college");
                        deanID = sc1.nextInt();

                        /*
                         Important Note: There isn't any check for duplicates. Tested insertion and it
                                         allowed me to keep inserting the same college name.

                         Side Note: College limit does work however.
                        */
                        college = new College(collegeName, deanID);
                        dbc.addCollege(db, college);

                        /*
                    if(){

                         System.out.println("College is being added.");
                        dbc.addCollege(db, college);
                    }
                    else{
                        System.out.println("College already exists.");
                    }
                         */
                        break;

                    case 3:
                        /*
                    First check if there are any colleges to add a department to
                    Yes : display list of options to add a department to
                    No : throw an error message stating to add a college first.
                         */
                        sc1.nextLine();

                        System.out.println("What college would you like to add a department to?");
                        //dbc.getCollege(db, sc1.nextLine());
                        collegeName = sc1.nextLine();


                        //character limit check
                        do {
                            System.out.println("Enter department name");

                            departmentName = sc1.nextLine();
                            if (departmentName.length() > 60) {
                                System.out.println("Too many characters for department name");
                            }
                        } while (departmentName.length() > 60);

                        // prompt for chairid
                        System.out.println("Enter in chairID");

                        chairID = sc1.nextInt();
                        department = new Department(departmentName,chairID);

                        //Insert department into specific college in database
                            /*
                            Important Note: When executing the dbc.addDepartment an exception is thrown if the college object doesn't exist
                            */
                        try {
                            dbc.addDepartment(db, collegeName, department);
                        } catch (Exception e) {
                            System.out.println("College doesn't exist");
                        }



                            /*if (chairID < 0 || chairID > ADMIN_ID_LIMIT) {
                                System.out.println("Invalid ID");
                            }

                        } while (chairID < 0 || chairID > ADMIN_ID_LIMIT);
                            */
                        //check for insertion limit
                        /*
                    Important note: may have to check if the same ids can span multiple heirarchy - adminID = departmentID = chairID.
                         */

                        // college.addDepartment(department);
                        //department = new Department("Comp", 000000111);
                        //college.addDepartment(department);
                        break;

                    case 4:
                        sc1.nextLine();

                        System.out.println("\nWhat college would you like to add a major to?");
                        collegeName = sc1.nextLine();
                        System.out.println("\nWhat college would you like to add a major to?");
                        departmentName = sc1.nextLine();


                        //character limit check
                        do {
                            System.out.println("Enter the major name");

                            majorName = sc1.nextLine();
                            if (majorName.length() > 60) {
                                System.out.println("Too many characters for department name");
                            }
                        } while (majorName.length() > 60);

                        major = new Major(majorName);

                        //Insert major into specific department
                        /*
                          Important Note: Throws an exception if the objects don't exist
                        */
                        try{
                            dbc.addMajor(db, collegeName, departmentName, major);
                        }catch(Exception e){
                            System.out.println("College or department doesn't exist");
                        }

                        break;

                    case 5:
                        sc1.nextLine();
                        System.out.println("\nWhat college would you like to add a course to?");
                        collegeName = sc1.nextLine();
                        System.out.println("\nWhat department would you like to add a course to?");
                        departmentName = sc1.nextLine();
                        System.out.println("\nWhat major would you like to add a course to?");
                        majorName = sc1.nextLine();

                        //character limit check
                        do {
                            System.out.println("Enter course name");

                            courseName = sc1.nextLine();
                            if (courseName.length() > 60) {
                                System.out.println("Too many characters for department name");
                            }
                        } while (courseName.length() > 60);
                        // total of 100 courses per major

                        // enter units for course

                        //Still working out error checking for entering units
                        units = sc1.nextInt();


                        course = new Course(courseName,units);

                        break;

                    case 6:
                        /*
                    Prompt for student name. ID is automatically assigned by increment variable
                    Insert student object into database via database control object.
                         */
                        sc1.nextLine();
                        System.out.println("Enter student name");

                        studentName = sc1.nextLine();

                        //stu = new Student(studentName, studentIDIncrement);
                        studentIDIncrement++;
                        // currently there is no method in the database control class to insert a student into the database

                        break;
                    case 7:
                        System.out.println("What would you like to edit");
                        edit_Menu();
                        break;
                    case 8:
                        System.out.println("What would you like to delete");
                       // delete_Menu();
                        break;

                    case 9:
                        System.out.println("Going back to login.");
                        sc1.nextLine();
                        return;
                    default:
                        System.out.println("Invalid option number\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc1.nextLine();
            }

        } while (optionSelect != 9);
 }

/*


    Huge space for visual appeal









    */
    /*
    public static void adminMenuDisplay() {
        System.out.println("1. Add College \n2. Add Department \n3. Add Major \n4. Add Courses \n5. Add Student \n6. Back");

        try {
            switch (sc1.nextInt()) {

                case 1:
                    System.out.println("Adding college test");
                    break;
                case 2:
                    System.out.println("Adding department test");
                    break;
                case 3:
                    System.out.println("Adding major test");
                    break;
                case 4:
                    System.out.println("Adding courses test");
                    break;
                case 5:
                    System.out.println("Adding student test");
                    break;
                case 6:
                    System.out.println("Going back to login.");
                    return;
                default:
                    System.out.println("Invalid option number");
                    adminMenuDisplay();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input\n");
            sc1.next();

        }
    }
*//*
    public static void studentMenuDisplay() {
        int input = 0;
        do {
            System.out.println("1. Add course \n2. Remove course \n3. Select major \n4. Back");

            try {
                switch (sc1.nextInt()) {
                    case 1:
                        System.out.println("Add course test");
                        break;
                    case 2:
                        System.out.println("Remove course test");
                        break;
                    case 3:
                        System.out.println("Select major test");
                        break;
                    case 4:
                        System.out.println("Going back to login\n");
                        sc1.nextLine();
                        return;
                    default:
                        System.out.println("Invalid option number\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input\n");
                sc1.next();
            }
        }while (input != 4);
    }
*/
    public static void printIDs(int ids) {
        //for (int i = 0; i < ids.size(); i++) {
            System.out.println("ID#: " + String.format("%09d", ids));
        //}
    }


    public static void edit_Menu(){
       sc1.nextLine();
        int input = 0;

        // College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back

        do {
             System.out.println("\n1. College \n2. Department \n3. Major \n4. Courses \n5. Session \n6. Building \n7. Room \n8. Student \n9. Employee \n10. Back");

            try {
                input = sc1.nextInt();
                switch (input) {
                    case 1:
                        //College
                        break;

                    case 2:
                        //Department
                        break;
                    case 3:
                        //Major
                        break;
                    case 4:
                        //Courses
                        break;
                    case 5:
                        //Session
                        break;
                    case 6:
                        //Building
                        break;
                    case 7:
                        //Room
                        break;
                    case 8:
                        //Student
                        break;
                    case 9:
                        //Employee
                        break;
                    case 10:
                        //Go back to previous menu
                        /*
                        dont need to add any logic here
                        */
                        sc1.nextLine();
                        break;

                    default:
                        System.out.println("Invalid option number");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc1.nextLine();
            }
        } while (input != 10);
    }
}





// formatID = String.format("%09d", loginput);   // convert user input into string and format for 9 digits


/*
if ( methodToGetObject == null)
"object doesn't not exist""
*/
