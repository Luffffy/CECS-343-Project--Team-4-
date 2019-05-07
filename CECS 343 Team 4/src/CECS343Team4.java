/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CECS343Team4 {

    private static Scanner sc1 = new Scanner(System.in);
    private static int IDIncrement = 4;
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
    private static int day = 0;
    private static int loginput;

    private static Database_Control dbc = new Database_Control();
    private static Database db = new Database();
    private static Employee_Control ec;
    private static Student_Control sco;
    private static College college;
    private static Department department;
    private static Major major;
    private static Course course;
    private static Employee employee;
    private static Student student;
    private static Session session;
    private static Building building;
    private static Room room;
    private static LocalTime startTime;
    private static LocalTime endTime;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        loginput = 0;

        String password = "";
        //String formatID = "";

       // ArrayList<Integer> adminIDs = new ArrayList<>();
       
       dbc.printIDs(db);

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

                } else if (dbc.employeeExists(db, loginput) && dbc.getEmployee(db, loginput).getAdmin()) {
                    System.out.println("Welcome admin");

                    //create admin menu
                    adminMenuDisplay();

                } else if (dbc.studentExists(db, loginput)) {
                    System.out.println("Welcome student");

                    // create student menu
                    studentMenuDisplay();
                } else {
                    System.out.println("Invalid id recognized\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input\n");
                //sc.next();

            }
        } while (loginput >= 0);

    }

    /*
    Edit or delete:
        options - College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back
    */

    public static void superUserMenuDisplay() {

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
                        id = sc1.nextInt();
                        
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
                        
                        //print out a list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
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

                         //print out a list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("What college would you like to add a department to?");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists before moving forward
                        if(dbc.getCollege(db, collegeName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        //print out a list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
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

                         //print out a list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("\nWhat college would you like to add a major to?");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                          if(dbc.getCollege(db, collegeName) == null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                          //print out a list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                          
                        System.out.println("\nWhat department would you like to add a major to?");
                        departmentName = sc1.nextLine();
                        
                        //check if the department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out a list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        

                        //character limit check
                        do {
                            System.out.println("\nEnter the major name");

                            majorName = sc1.nextLine();
                            if (majorName.length() > 60) {
                                System.out.println("Too many characters for major name");
                            }
                        } while (majorName.length() > 60);

                        major = new Major(majorName);
                        dbc.addMajor(db, collegeName, departmentName, major);

                        break;

                    case 6:
                        //add course
                        sc1.nextLine();
                        
                        //print out a list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("\nWhat college would you like to add a course to?");
                        collegeName = sc1.nextLine();
                        
                        // checking if college exists before going any further
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist.");
                            break;
                        }
                        
                        // print list of departments in college
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("\nWhat department would you like to add a course to?");
                        departmentName = sc1.nextLine();
                        
                        //checking if department exists before going any further
                            if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print list of majors in the department
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("\nWhat major would you like to add a course to?");
                        majorName = sc1.nextLine();

                        //check if major exists before going any further
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        //character limit check
                        do {
                            System.out.println("\nEnter course name");

                            courseName = sc1.nextLine();
                            if (courseName.length() > 60) {
                                System.out.println("Too many characters for course name");
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
                        
                        //print list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you wish to add a session to");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                        if(dbc.getCollege(db, roomName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments for that college
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department you wish to add a session to");
                        departmentName = sc1.nextLine();
                        
                        // check if department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors for that department
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major you wish to add a session to");
                        majorName = sc1.nextLine();
                        
                        //check if major exists before moving forward
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out the list of courses for that major
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter the course you wish to add a session to");
                        courseName = sc1.nextLine();
                        
                        //check if course exists before moving forward
                        
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName) == null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        //print out list of session numbers
                        System.out.println("List of Sessions: " + dbc.getCourse(db, collegeName, departmentName, majorName, courseName).getSessions());
                        
                        System.out.println("Enter the session number");
                        sessionNumber = sc1.nextLine();
                        
                        
                        
                        
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
                        
                        
                        System.out.println("Enter in the day. 1-7 for Monday - Sunday");
                        day = sc1.nextInt();
                        
                        
                        
                        System.out.println("What is the start time. Enter in this format 00:00");
                        startTime = LocalTime.parse(sc1.nextLine());
                        
                        System.out.println("What is the end time. Enter in this format 00:00");
                        endTime = LocalTime.parse(sc1.nextLine());
                        
                        Session temp = new Session( "tempName", -1, day, semester, building, room, startTime, endTime, course);
   
                        
                        //List all of the employees
                        /****************/
                        dbc.printEmployeeIDs(db);
                      
                        System.out.println("\nEnter in the professor id");
                        id = sc1.nextInt();
                        
                        
                        
                        if(!ec.checkClassConflict(dbc.getEmployee(db, id), temp)){
                            Session add = new Session ( sessionNumber , id, day, semester, building, room, startTime, endTime, course);
                            dbc.addSession(db, collegeName, departmentName, majorName, courseName, add);
                        }
                         else
                        {
                            System.out.println("Cannot add this session because it conflicts with the profs teaching schedule");
                        }
                        
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
                        
                        dbc.printBuildingNames(db);
                        
                        System.out.println("\nEnter the building to insert room into");
                        buildingName = sc1.nextLine();
                       
                        //check if building exists before moving forward
                        if(dbc.getBuilding(db, buildingName)== null){
                            System.out.println("Building doesn't exist");
                            break;
                        }
                        
                        //print out a list of rooms
                        System.out.println("List of Rooms: " + dbc.getBuilding(db, buildingName).getRooms());
                        
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
                        edit_Menu();
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


    
    public static void adminMenuDisplay() {
        
        do {
            System.out.println("\nAdmin Priviledges \n1. Add Employee \n2. Add College \n3. Add Department \n4. Add Major \n5. Add Courses \n6. Add Student \n7. Add Session \n8. Add Building \n9. Add Room \n10. Edit \n11. Delete \n12. Back");

            try {

                optionSelect = sc1.nextInt();

                switch (optionSelect) {
                   
                    case 1:
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
                        
                    case 2:
                        //add college
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
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
                         Important Note: There isn't any check for duplicates. Tested insertion and it
                                         allowed me to keep inserting the same college name.

                         Side Note: College limit does work however.
                        */
                        college = new College(collegeName, deanID);
                        dbc.addCollege(db, college);

                        break;

                    case 3:
                        //add department
                        /*
                    First check if there are any colleges to add a department to
                    Yes : display list of options to add a department to
                    No : throw an error message stating to add a college first.
                         */
                        sc1.nextLine();
                        
                        //display list of college
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("What college would you like to add a department to?");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists before moving forward
                        if(dbc.getCollege(db, collegeName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }

                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
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

                    case 4:
                        //add major
                        sc1.nextLine();

                        //display list of departments and colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("\nWhat college would you like to add a major to?");
                        collegeName = sc1.nextLine();
                        
                        
                        //check if college exists before moving forward
                          if(dbc.getCollege(db, collegeName) == null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                          //print out list of departments
                          System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                          
                        System.out.println("\nWhat department would you like to add a major to?");
                        departmentName = sc1.nextLine();
                        
                        //check if the department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());

                        //character limit check
                        do {
                            System.out.println("\nEnter the major name");

                            majorName = sc1.nextLine();
                            if (majorName.length() > 60) {
                                System.out.println("Too many characters for Major name");
                            }
                        } while (majorName.length() > 60);

                        major = new Major(majorName);
                        dbc.addMajor(db, collegeName, departmentName, major);

                        break;

                    case 5:
                        //add course
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " +dbc.getUniversity(db).getColleges());
                        
                        System.out.println("\nWhat college would you like to add a course to?");
                        collegeName = sc1.nextLine();
                        
                        // checking if college exists before going any further
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist.");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " +dbc.getCollege(db,collegeName).getDepartments());
                        
                        System.out.println("\nWhat department would you like to add a course to?");
                        departmentName = sc1.nextLine();
                        
                        //checking if department exists before going any further
                            if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                            
                            //print out list of majors
                            System.out.println("List of Majors: " +dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        
                        System.out.println("\nWhat major would you like to add a course to?");
                        majorName = sc1.nextLine();

                        //check if major exists before going any further
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out a list of courses
                        System.out.println("List of Courses: " +dbc.getMajor(db, collegeName, departmentName, majorName));
                        
                        //character limit check
                        do {
                            System.out.println("\nEnter course name");

                            courseName = sc1.nextLine();
                            if (courseName.length() > 60) {
                                System.out.println("Too many characters for Course name");
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

                    case 6:
                        // add student
                        sc1.nextLine();
                        System.out.println("Enter student name");

                        studentName = sc1.nextLine();
                        
                        student = new Student(studentName, IDIncrement);
                        dbc.addStudent(db, student);
                        IDIncrement++;
                        
                        break;
                        
                    case 7:
                        //add session
                        sc1.nextLine();
                        
                        //print out a list of colleges
                        System.out.println(dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you wish to add a session to");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                        if(dbc.getCollege(db, roomName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out a list of departments
                        System.out.println(dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department you wish to add a session to");
                        departmentName = sc1.nextLine();
                        
                        // check if department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out a list of majors
                        System.out.println(dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major you wish to add a session to");
                        majorName = sc1.nextLine();
                        
                        //check if major exists before moving forward
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out a list of courses
                        System.out.println(dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter the course you wish to add a session to");
                        courseName = sc1.nextLine();
                        
                        //check if course exists before moving forward
                        
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName) == null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        //print out a list of sessions
                        System.out.println(dbc.getCourse(db, collegeName, departmentName, majorName, courseName).getSessions());
                        
                        System.out.println("Enter the session number");
                        sessionNumber = sc1.nextLine();
                        
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
                        
                        System.out.println("Enter in the day. 1-7 for Monday - Sunday");
                        day = sc1.nextInt();
                        
                        System.out.println("What is the start time. Enter in this format 00:00");
                        startTime = LocalTime.parse(sc1.nextLine());
                        
                        System.out.println("What is the end time. Enter in this format 00:00");
                        endTime = LocalTime.parse(sc1.nextLine());
                        
                        
                        Session temp = new Session( "tempName", -1, day, semester, building, room, startTime, endTime, course);
   
                        System.out.println("Enter in the professor id");
                        id = sc1.nextInt();                     
                        
                        if(!ec.checkClassConflict(dbc.getEmployee(db, id), temp)){
                            Session add = new Session ( sessionNumber , id, day, semester, building, room, startTime, endTime, course);
                            dbc.addSession(db, collegeName, departmentName, majorName, courseName, add);
                        }
                         else
                        {
                            System.out.println("Cannot add this session because it conflicts with the profs teaching schedule");
                        }
                        break;
                        
                    case 8:
                        sc1.nextLine();
                        //add building
                        dbc.printBuildingNames(db);
                        System.out.println("\nEnter in the building name");
                        String name = sc1.nextLine();
                        
                        System.out.println("Enter in the occupancy limit");
                        limit = sc1.nextInt();
                        
                        building = new Building(name,limit);
                        dbc.addBuilding(db, building);
                        
                        break;
                        
                        
                    case 9:
                        //add room
                        sc1.nextLine();
                        
                        dbc.printBuildingNames(db);
                        System.out.println("\nEnter the building to insert room into");
                        buildingName = sc1.nextLine();
                       
                        //print out a list of rooms
                            System.out.println("List of Roomss: " +  dbc.getBuilding(db, buildingName).getRooms());
                        
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
                        
                        
                    case 10:
                        //Edit
                        System.out.println("What would you like to edit");
                        edit_Menu();
                        break;
                    case 11:
                        //Delete
                        System.out.println("What would you like to delete");
                        delete_Menu();
                        break;

                    case 12:
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

        } while (optionSelect != 12);
 }
        

    public static void studentMenuDisplay() {
        
        int studentMenuInput = 0;
        
        do {
            System.out.println("1. Add course \n2. Remove course \n3. Select major \n4. Back");

            try {
                studentMenuInput = sc1.nextInt();
                switch (studentMenuInput) {
                    case 1:
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you wish to add a session to");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists before moving forward
                        if(dbc.getCollege(db, roomName)== null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department you wish to add a session to");
                        departmentName = sc1.nextLine();
                        
                        // check if department exists before moving forward
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major you wish to add a session to");
                        majorName = sc1.nextLine();
                        
                        //check if major exists before moving forward
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter the course you wish to add a session to");
                        courseName = sc1.nextLine();
                        
                        //check if course exists before moving forward
                        
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName) == null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        //print out a list of sessions
                        System.out.println("List of Sessions: " + dbc.getCourse(db, collegeName, departmentName, majorName, courseName).getSessions());
                        
                        System.out.println("Enter the session number");
                        sessionNumber = sc1.nextLine();
                        
                       /*
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
                        */
                        
                        sco.addSession(db, loginput, dbc.getSession(db, collegeName, departmentName, majorName, courseName, sessionNumber));
                        
                        break;
                    case 2:
                        //remove course
                        sc1.nextLine();
                        
                        /*
                        Have to test if this works
                        */
                        System.out.println("Enter in the session number of the session you wish to remove");
                        sessionNumber = sc1.nextLine();
                        
                        sco.removeSession(db, loginput, sessionNumber);
                        break;
                    case 3:
                        //select major
                        
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        System.out.println("Enter in a college to select a major");
                        
                        collegeName = sc1.nextLine();
                        
                        if(dbc.getCollege(db, collegeName) == null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments to select major
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to select a major from");
                        departmentName = sc1.nextLine();
                        
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Select the major");
                        majorName = sc1.nextLine();
                        
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        sco.changeMajor(db, loginput, majorName);
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
        }while (studentMenuInput != 4);
    }

    public static void delete_Menu(){
       sc1.nextLine();
        int deleteinput = 0;

        // College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back

        do {
             System.out.println("\n1. College \n2. Department \n3. Major \n4. Courses \n5. Session \n6. Building \n7. Room \n8. Student \n9. Employee \n10. Back");

            try {
                deleteinput = sc1.nextInt();
                switch (deleteinput) {
                    case 1:
                        //College
                        sc1.nextLine();
                        
                        //print list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you wish to delete");
                        collegeName = sc1.nextLine();
                        dbc.removeCollege(db, collegeName);
                        break;

                    case 2:
                        //Department
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you want to delete a department from");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department you wish to delete");
                        departmentName = sc1.nextLine();
                        
                        dbc.removeDepartment(db, collegeName, majorName);
                        break;
                        
                    case 3:
                        //Major
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to delete a major from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to delete a major from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName));
                        
                        System.out.println("Enter in the major you wish to delete");
                        majorName = sc1.nextLine();
                        dbc.removeMajor(db, collegeName, departmentName, majorName);
                        break;
                        
                    case 4:
                        //Courses
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to delete a course from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to delete a course from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major to delete a course from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter in the course you wish to delete");
                        courseName = sc1.nextLine();
                        
                        dbc.removeCourse(db, collegeName, departmentName, majorName, courseName);
                        break;
                    case 5:
                        //Session
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to delete a session from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to delete a session from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major to delete a session from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter in the course to delete a session from");
                        courseName = sc1.nextLine();
                        
                        //check if course exists
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName)==null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        //print out list of sessions
                        System.out.println("List of Sessions: " + dbc.getCourse(db, collegeName, departmentName, majorName, courseName).getSessions());
                        
                        System.out.println("Enter in the session number to delete a session");
                        sessionNumber = sc1.nextLine();
                        
                        dbc.removeSession(db, collegeName, departmentName, majorName, courseName, sessionNumber);
                        
                        
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
                        
                        dbc.printBuildingNames(db);
                        
                        System.out.println("\nEnter in the building you wish to delete a room from");
                        buildingName = sc1.nextLine();
                        
                        if(dbc.getBuilding(db, buildingName)==null){
                            System.out.println("Building doesn't exist");
                            break;
                        }
                        
                        //print out list of rooms
                        System.out.println("List of Rooms: " + dbc.getBuilding(db, buildingName).getRooms());
                        
                        System.out.println("Enter in the room you wish to delete");
                        roomName = sc1.nextLine();
                        
                        dbc.removeRooms(db, buildingName, roomName);
                        
                        break;
                    case 8:
                        //Student
                        sc1.nextLine();
                        
                        /********print list of students*********/
                        dbc.printStudentIDs(db);
                        
                        System.out.println("\nEnter in the ID of the student you wish to delete.");
                        
                        id = sc1.nextInt();
                        dbc.removeStudent(db, id);
                        
                        break;
                        
                    case 9:
                        //Employee
                        sc1.nextLine();
                        
                        /******print list of employees *******/
                        dbc.printEmployeeIDs(db);
                        
                        System.out.println("\nEnter in the ID of the employee you wish to delete");
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
        } while (deleteinput != 10);
    }
    
    
    public static void edit_Menu(){
        sc1.nextLine();
        int editinput = 0;

        // College, Department, Major, Courses, Session, Building, Room, Student, Employee, Option to go back

        do {
             System.out.println("\n1. College \n2. Department \n3. Major \n4. Courses \n5. Session \n6. Building \n7. Room \n8. Student \n9. Employee \n10. Back");

            try {
                editinput = sc1.nextInt();
                switch (editinput) {
                    case 1:
                        //College
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you wish to edit");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName) == null){
                            System.out.println("The college doesn't exist");
                            break;
                        }
                        
                        System.out.println("Would you like to change the college name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the college name");
                            dbc.getCollege(db, collegeName).setCollegeName(sc1.nextLine());
                        }
                        
                        System.out.println("Would you like to change the college dean ID? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the college dean ID");
                            dbc.getCollege(db, collegeName).setDeanID(sc1.nextInt());
                        }
                        
                        
                        break;

                    case 2:
                        //Department
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college you want to edit a department from");
                        collegeName = sc1.nextLine();
                        
                        // check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department you wish to edit");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName) == null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        System.out.println("Would you like to change the department name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the department name");
                            dbc.getDepartment(db, collegeName, departmentName).setDepartmentName(sc1.nextLine());
                        }
                        
                        System.out.println("Would you like to change the department chair ID? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the department chair ID");
                            dbc.getDepartment(db, collegeName, departmentName).setChairID(sc1.nextInt());
                        }
                        
                        
                        break;
                        
                    case 3:
                        //Major
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to edit a major from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to edit a major from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major you wish to edit");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName) == null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        System.out.println("Change the major name to ");
                        dbc.getMajor(db, collegeName, departmentName,majorName).setMajorName(sc1.nextLine());
                        
                        
                        break;
                        
                    case 4:
                        //Courses
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to edit a course from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db,collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to edit a course from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major to edit a course from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter in the course you wish to edit");
                        courseName = sc1.nextLine();
                        
                        //check if course exists
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName) == null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        System.out.println("Would you like to change the course name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the course name");
                            dbc.getCourse(db, collegeName, departmentName, majorName, courseName).setCourseName(sc1.nextLine());
                        }
                        
                        System.out.println("Would you like to change the course units? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the course units");
                            dbc.getCourse(db, collegeName, departmentName, majorName, courseName).setCourseUnits(sc1.nextInt());
                        }
              
                        break;
                        
                    case 5:
                        //Session
                        sc1.nextLine();
                        
                        //print out list of colleges
                        System.out.println("List of Colleges: " + dbc.getUniversity(db).getColleges());
                        
                        System.out.println("Enter in the college to edit a session from");
                        collegeName = sc1.nextLine();
                        
                        //check if college exists
                        if(dbc.getCollege(db, collegeName)==null){
                            System.out.println("College doesn't exist");
                            break;
                        }
                        
                        //print out list of departments
                        System.out.println("List of Departments: " + dbc.getCollege(db, collegeName).getDepartments());
                        
                        System.out.println("Enter in the department to edit a session from");
                        departmentName = sc1.nextLine();
                        
                        //check if department exists
                        if(dbc.getDepartment(db, collegeName, departmentName)==null){
                            System.out.println("Department doesn't exist");
                            break;
                        }
                        
                        //print out list of majors
                        System.out.println("List of Majors: " + dbc.getDepartment(db, collegeName, departmentName).getMajors());
                        
                        System.out.println("Enter in the major to edit a session from");
                        majorName = sc1.nextLine();
                        
                        //check if major exists
                        if(dbc.getMajor(db, collegeName, departmentName, majorName)==null){
                            System.out.println("Major doesn't exist");
                            break;
                        }
                        
                        //print out list of courses
                        System.out.println("List of Courses: " + dbc.getMajor(db, collegeName, departmentName, majorName).getCourses());
                        
                        System.out.println("Enter in the course to edit a session from");
                        courseName = sc1.nextLine();
                        
                        //check if course exists
                        if(dbc.getCourse(db, collegeName, departmentName, majorName, courseName)==null){
                            System.out.println("Course doesn't exist");
                            break;
                        }
                        
                        //print out list of sessions
                        System.out.println("List of Sessions: " + dbc.getCourse(db, collegeName, departmentName, majorName, courseName).getSessions());
                        
                        System.out.println("Enter in the session number to edit the session");
                        sessionNumber = sc1.nextLine();
                        
                        //check if session exists
                        if(dbc.getSession(db, collegeName, departmentName, majorName, courseName, sessionNumber) == null){
                            System.out.println("Session doesn't exist");
                            break;
                        }
                        
                        
                        System.out.println("Do you wish to edit the session day? y or n");
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the session day");
                            dbc.getSession(db, collegeName, departmentName, majorName, courseName,sessionNumber).setDay(sc1.nextInt());
                        }
                        
                        
                        System.out.println("Do you wish to edit the session professor? y or n");
                        if (sc1.nextLine().compareToIgnoreCase("y") == 0) {
                            System.out.println("Change the session professor");
                            
                            Session temp = new Session("tempName", -1, day, semester, building, room, startTime, endTime, course);

                            System.out.println("Enter in the professor id");
                            id = sc1.nextInt();

                            // check for time conflict with professor
                            if (!ec.checkClassConflict(dbc.getEmployee(db, id), temp)) {
                                
                                dbc.getSession(db, collegeName, departmentName, majorName, courseName, sessionNumber).setProf(id);
                            } else {
                                System.out.println("Cannot add this session because it conflicts with the profs teaching schedule");
                                
                            }
                            
                        }
                        
                        System.out.println("Do you wish to edit the session building? y or n");
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the session building");
                            buildingName = sc1.nextLine();
                            dbc.getSession(db, collegeName, departmentName, majorName, courseName,sessionNumber).setBuilding(dbc.getBuilding(db, buildingName));
                        }
                        
                        System.out.println("Do you wish to edit the session room? y or n");
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the session room");
                            dbc.getSession(db, collegeName, departmentName, majorName, courseName,sessionNumber).setRoom(dbc.getRoom(db, buildingName , sc1.nextLine()));
                        }
                        
                        System.out.println("Do you wish to edit the session time? y or n");
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the session time");
                            dbc.getSession(db, collegeName, departmentName, majorName, courseName,sessionNumber).setTime(LocalTime.parse(sc1.nextLine()), LocalTime.parse(sc1.nextLine()));
                        }
                        
                        break;
                    case 6:
                        //Building
                        sc1.nextLine();
                        
                        System.out.println("Enter in the building you wish to edit");
                        buildingName = sc1.nextLine();
                        
                        System.out.println("Would you like to change the building name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the building name");
                            dbc.getBuilding(db, buildingName).setBuildingName(sc1.nextLine());
                        }
                        
                        System.out.println("Would you like to change the building occupancy limit? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the occupancy limit");
                            dbc.getBuilding(db, buildingName).setOccupancyLimit(sc1.nextInt());
                        }
                        
                        break;
                        
                    case 7:
                        //Room
                        sc1.nextLine();
                        
                        dbc.printBuildingNames(db);
                        
                        System.out.println("\nEnter in the building you wish to edit a room from");
                        buildingName = sc1.nextLine();
                        
                        //check if building exists
                        if(dbc.getBuilding(db, buildingName)==null){
                            System.out.println("Building doesn't exist");
                            break;
                        }
                        
                        //print out list of rooms
                        System.out.println("List of Rooms: " + dbc.getBuilding(db, buildingName).getRooms());
                        
                        System.out.println("Enter in the room you wish to delete");
                        roomName = sc1.nextLine();
                        
                        //check if room exists
                        if(dbc.getRoom(db, buildingName, roomName) == null){
                            System.out.println("Room doesn't exist");
                            break;
                        }
                        
                        System.out.println("Would you like to change the room name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the room name");
                            dbc.getRoom(db, buildingName, roomName).setRoomName(sc1.nextLine());
                        }
                        
                        System.out.println("Would you like to change the room occupancy limit? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the room occupancy limit");
                            dbc.getRoom(db, buildingName, roomName).setOccupancyLimit(sc1.nextInt());
                        }
                        
                        break;
                    case 8:
                        //Student
                        sc1.nextLine();
                        
                        /******list id of all students **********/
                        
                        System.out.println("Enter in the ID of the student you wish to edit.");
                        
                        id = sc1.nextInt();
                        sc1.nextLine();
                        System.out.println("Would you like to change the student name? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the student name");
                            dbc.getStudent(db, id).setStudentName(sc1.nextLine());
                        }
                        
                        
                        System.out.println("Would you like to change the student ID? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the student ID");
                            dbc.getStudent(db, id).setStudentID(sc1.nextInt());
                        }
                        
                        System.out.println("Did the student pay? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            
                            dbc.getStudent(db, id).setTuition(true);
                        }
                        else{
                            dbc.getStudent(db, id).setTuition(false);
                        }
                        
                        break;
                    case 9:
                        //Employee
                        sc1.nextLine();
                        
                        /**********list id of all employees *************/
                        System.out.println();
                        System.out.println("Enter in the ID of the employee you wish to edit");
                        id = sc1.nextInt();
                        
                        System.out.println("Would you like to change the employee ID? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the employee ID");
                            dbc.getEmployee(db, id).setID(sc1.nextInt());
                        }
                        
                        System.out.println("Would you like to change the employee admin status? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            dbc.getEmployee(db, id).setAdmin(false);
                        }
                        
                        System.out.println("Would you like to change the employee salary? y or n");
                      
                        if(sc1.nextLine().compareToIgnoreCase("y")==0){
                            System.out.println("Change the employee salary");
                            dbc.getEmployee(db, id).setSalary(sc1.nextFloat());
                        }
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
        } while (editinput != 10);
    }
}

// formatID = String.format("%09d", loginput);   // convert user input into string and format for 9 digits

