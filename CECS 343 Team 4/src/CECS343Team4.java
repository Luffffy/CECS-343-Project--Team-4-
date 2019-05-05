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
    private static int IDIncrement = 1;
     // user input variables
    private static String employeeName = "";
    private static String collegeName = "";
    private static String departmentName = "";
    private static String majorName = "";
    private static String courseName = "";
    private static String studentName = "";
    private static String buildingName = "";
    private static String roomName = "";
    private static String sessionNumber = "";
    private static String input = "";
    private static boolean semester = false;
    private static float employeeSalary = 0;
    private static int employeeID = 0;
    private static int deanID = 0;
    private static int chairID = 0;
    private static int optionSelect = 0;
    private static int units = 0;
    private static int limit = 0;
    private static int id = 0;
    

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

                } else if (dbc.getEmployee(db, loginput).getAdmin()) {
                    System.out.println("Welcome admin");

                    //create admin menu
                    //adminMenuDisplay();

                } else if (dbc.getStudent(db, loginput) == null) {
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
        Employee employee;
        Student student;
        Session session;
        Building building;
        Room room;



        do {
            System.out.println("\nSuperUser Priviledges \n1. Add Admin \n2. Add Employee \n3. Add College \n4. Add Department \n5. Add Major \n6. Add Courses \n7. Add Student \n8. Add Session \n9. Add Building \n10. Add Room \n11. Edit \n12. Delete \n13. Back");

            try {

                optionSelect = sc1.nextInt();

                switch (optionSelect) {
                    case 1:
                        sc1.nextLine();
                    //for setting an Admin
                        //Database_Control dbc = new Database_Control();
                        System.out.println("Enter the ID of the Employee you want to assign as Admin");
                        int id = sc1.nextInt();
                        
                        dbc.setAdmin(db, id, true);
                        sc1.nextLine();
                        break;

                    case 2:
                        //for adding an Employee
                        sc1.nextLine();
                        System.out.println("Enter the employees name");
                        employeeName = sc1.nextLine();

                        System.out.println("Enter in the employees salary");
                        employeeSalary = sc1.nextFloat();

                        employee = new Employee(employeeName,IDIncrement,employeeSalary);
                        
                        dbc.addEmployee(db, employee);
                        IDIncrement++;
                        
                        break;
                        
                    case 3:
                        //add college
                        sc1.nextLine();
                        
                        //character limit checking for college name
                        do {
                            System.out.println("Enter college name");
                            collegeName = sc1.nextLine();
                            if (collegeName.length() > 60) {
                                System.out.println("Too many characters in college name");
                            }

                        } while (collegeName.length() > 60);

                        System.out.println("Enter deanID for this college");
                        deanID = sc1.nextInt();
                        
                        /*
                        There is no way to check for employees
                        */
                        

                        /*
                         Important Note: There isn't any check for duplicates. Tested insertion and it
                                         allowed me to keep inserting the same college name.

                         Side Note: College limit does work however.
                        */
                        college = new College(collegeName, deanID);
                        dbc.addCollege(db, college);

                        break;

                    case 4:
                        //add department
                        /*
                    First check if there are any colleges to add a department to
                    Yes : display list of options to add a department to
                    No : throw an error message stating to add a college first.
                         */
                        sc1.nextLine();

                        System.out.println("What college would you like to add a department to?");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists before moving forward
                        if(dbc.getCollege(db, collegeName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }

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
                        dbc.addDepartment(db, collegeName, department);
                        System.out.println("Department has been added");
                       
                        break;

                    case 5:
                        //add major
                        sc1.nextLine();

                        System.out.println("\nWhat college would you like to add a major to?");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                          if(dbc.getCollege(db, collegeName) == null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                          
                        System.out.println("\nWhat department would you like to add a major to?");
                        departmentName = sc1.nextLine();
                        
                        //check if the department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }

                        //character limit check
                        do {
                            System.out.println("\nEnter the major name");

                            majorName = sc1.nextLine();
                            if (majorName.length() > 60) {
                                System.out.println("Too many characters for department name");
                            }
                        } while (majorName.length() > 60);

                        major = new Major(majorName);
                        dbc.addMajor(db, collegeName, departmentName, major);

                        break;

                    case 6:
                        //add course
                        sc1.nextLine();
                        
                        System.out.println("\nWhat college would you like to add a course to?");
                        collegeName = sc1.nextLine();
                        
                        // checking if college exists before going any further
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist.");
                            break;
                        }
                        
                        System.out.println("\nWhat department would you like to add a course to?");
                        departmentName = sc1.nextLine();
                        
                        //checking if department exists before going any further
                            if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        
                        System.out.println("\nWhat major would you like to add a course to?");
                        majorName = sc1.nextLine();

                        //check if major exists before going any further
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //character limit check
                        do {
                            System.out.println("\nEnter course name");

                            courseName = sc1.nextLine();
                            if (courseName.length() > 60) {
                                System.out.println("Too many characters for department name");
                            }
                        } while (courseName.length() > 60);
                        

                        // enter units for course
                        do{
                            System.out.println("\nEnter the units for this course.");
                            try{
                                units = sc1.nextInt();
                            }
                            catch(Exception e){
                                System.out.println("Invalid Input");
                                sc1.nextLine();
                            }
                            } while(units < 1);

                        course = new Course(courseName,units);
                        dbc.addCourse(db, collegeName, departmentName, majorName, course);

                        break;

                    case 7:
                        // add student
                        sc1.nextLine();
                        System.out.println("Enter student name");

                        studentName = sc1.nextLine();
                        
                        student = new Student(studentName, IDIncrement);
                        dbc.addStudent(db, student);
                        IDIncrement++;
                        
                        break;
                        
                    case 8:
                        //add session
                        sc1.nextLine();
                        
                        System.out.println("Enter in the college you wish to add a session to");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                        if(dbc.getCollege(db, roomName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the department you wish to add a session to");
                        departmentName = sc1.nextLine();
                        
                        // check if department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the major you wish to add a session to");
                        majorName = sc1.nextLine();
                        
                        //check if major exists before moving forward
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        
                        System.out.println("Enter the course you wish to add a session to");
                        courseName = sc1.nextLine();
                        
                        //check if course exists before moving forward
                        
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName) == null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter the session number");
                        sessionNumber = sc1.nextLine();
                        
                        System.out.println("Enter in the professor id");
                        id = sc1.nextInt();
                        
                        System.out.println("Enter in the semester fall or spring");
                        input = sc1.nextLine();
                        if(input.compareToIgnoreCase("fall") == 0){
                            semester = false;
                        }
                        else if(input.compareToIgnoreCase("spring") == 0){
                            semester = true;
                        }
                        else{
                            System.out.println("Invalid input");
                            break;
                        }
                        
                        System.out.println("Enter in the day");
                        
                        
                        break;
                        
                    case 9:
                        sc1.nextLine();
                        //add building
                        System.out.println("Enter in the building name");
                        String name = sc1.nextLine();
                        
                        System.out.println("Enter in the occupancy limit");
                        limit = sc1.nextInt();
                        
                        building = new Building(name,limit);
                        dbc.addBuilding(db, building);
                        
                        break;
                        
                        
                    case 10:
                        //add room
                        sc1.nextLine();
                        
                        System.out.println("Enter the building to insert room into");
                        buildingName = sc1.nextLine();
                       
                        //check if building exists before moving forward
                        if(dbc.getBuilding(db, buildingName)== null){
                            System.out.println("Building doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the room name");
                        roomName = sc1.nextLine();
                        
                        System.out.println("Enter in the room size");
                        limit = sc1.nextInt();
                        
                        room = new Room(roomName,limit);
                        dbc.addRoom(db, buildingName, room);
                        
                        break;
                        
                        
                    case 11:
                        //Edit
                        System.out.println("What would you like to edit");
                        //edit_Menu();
                        break;
                    case 12:
                        //Delete
                        System.out.println("What would you like to delete");
                        delete_Menu();
                        break;

                    case 13:
                        //Return
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

        } while (optionSelect != 13);
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


    public static void delete_Menu(){
       sc1.nextLine();
        int input = 0;

        // College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back

        do {
             System.out.println("\n1. College \n2. Department \n3. Major \n4. Courses \n5. Session \n6. Building \n7. Room \n8. Student \n9. Employee \n10. Back");

            try {
                input = sc1.nextInt();
                switch (input) {
                    case 1:
                        sc1.nextLine();
                        //College
                        System.out.println("Enter in the college you wish to delete");
                        collegeName = sc1.nextLine();
                        dbc.removeCollege(db, collegeName);
                        break;

                    case 2:
                        sc1.nextLine();
                        //Department
                        System.out.println("Enter in the college you want to delete a department from");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the department you wish to delete");
                        departmentName = sc1.nextLine();
                        
                        dbc.removeDepartment(db, collegeName, majorName);
                        break;
                    case 3:
                        sc1.nextLine();
                        //Major
                        System.out.println("Enter in the college to delete a major from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the department to delete a major from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the major you wish to delete");
                        majorName = sc1.nextLine();
                        dbc.removeMajor(db, collegeName, departmentName, majorName);
                        break;
                        
                    case 4:
                        sc1.nextLine();
                        //Courses
                        System.out.println("Enter in the college to delete a course from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the department to delete a course from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the major to delete a course from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the course you wish to delete");
                        courseName = sc1.nextLine();
                        
                        dbc.removeCourse(db, collegeName, departmentName, majorName, courseName);
                        break;
                    case 5:
                        sc1.nextLine();
                        //Session
                        System.out.println("Enter in the college to delete a session from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the department to delete a session from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the major to delete a session from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the course to delete a session from");
                        courseName = sc1.nextLine();
                        
                        //check if course exists
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName)==null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        
                        break;
                    case 6:
                        //Building
                        sc1.nextLine();
                        
                        System.out.println("Enter in the building you wish to delete");
                        buildingName = sc1.nextLine();
                        
                        dbc.removeBuilding(db, buildingName);
                        
                        break;
                    case 7:
                        //Room
                        sc1.nextLine();
                        
                        System.out.println("Enter in the building you wish to delete a room from");
                        buildingName = sc1.nextLine();
                        
                        if(dbc.getBuilding(db, buildingName)==null){
                            System.out.println("Building doesn't exist");
                            break;
                        }
                        
                        System.out.println("Enter in the room you wish to delete");
                        roomName = sc1.nextLine();
                        
                        dbc.removeRooms(db, buildingName, roomName);
                        
                        break;
                    case 8:
                        //Student
                        sc1.nextLine();
                        System.out.println("Enter in the ID of the student you wish to delete.");
                        
                        id = sc1.nextInt();
                        dbc.removeStudent(db, id);
                        
                        break;
                    case 9:
                        //Employee
                        sc1.nextLine();
                        System.out.println("Enter in the ID of the employee you wish to delete");
                        id = sc1.nextInt();
                        dbc.removeEmployee(db, id);
                        
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
