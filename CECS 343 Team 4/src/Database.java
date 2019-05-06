import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Database {
    private University uni;
    private HashMap<Integer, Student> Students;
    private HashMap<Integer, Employee> Employees; 
    private HashMap<String, Building> Buildings;
    
    public Database()
    {
        uni = new University("University of Geeks");
        Students = new HashMap<Integer, Student>();
        Employees = new HashMap<Integer, Employee>();
        Buildings = new HashMap<String, Building>();
        initialize();
        
        
    }
    
    public University getUni()
    {
        return uni;
    }
    
    public HashMap getStudents()
    {
        return Students;
    }
    
    public HashMap getEmployees()
    {
        return Employees;
    }
    
    public HashMap getBuildings()
    {
        return Buildings;
    }
    
    public Student getStudent( int sID)
    {
        if(studentExists(sID))
        {
            //System.out.println("Student is found");
            return (Student) getStudents().get(sID);
        }
        //System.out.println("Student not found");
        return null;
    }
    
    public Employee getEmployee( int eID)
    {
        if(employeeExists(eID))
        {
            //System.out.println("Employee is found");
            return (Employee) getEmployees().get(eID);
        }
        //System.out.println("Employee not found");
        return null;
    }
    
    public Building getBuilding(String name)
    {
        if(getBuildings().containsKey(name))
        {
            //System.out.println("Building is found");
            return (Building) getBuildings().get(name);
        }
        //System.out.println("Building is not found");
        return null;
    }
    
    public boolean studentExists( int sID)
    {
        return getStudents().containsKey(sID);
    }
    
    public boolean employeeExists( int eID)
    {
        return getEmployees().containsKey(eID);
    }
    
    public boolean buildingExists(String name)
    {
        return getBuildings().containsKey(name);
    }
    
    public void printIDs()
    {
        
        for(Map.Entry e: Employees.entrySet())
        {
            System.out.println("Key:" + e.getKey() + " Value: " + ((Employee)e.getValue()).toString());
        }
        
        for(Map.Entry s: Students.entrySet())
        {
            System.out.println("Key:" + s.getKey() + " Value: " + ((Student)s.getValue()).toString());
        }
        
        
    }
    
    public void initialize()
    {
        Database_Control dbc = new Database_Control();
        Admin_Control ac = new Admin_Control();
        Student_Control sc = new Student_Control();
        
        //adding an employee
        System.out.println("Adding an Employee");
        Employee tempe1 = new Employee("EmployeeName", 1, 0);
        dbc.addEmployee(this, tempe1);
        System.out.println();
        
        //adding an employee and making them an admin
        System.out.println("adding an employee and making them an admin");
        Employee tempe2 = new Employee("AdminName", 2, 0);
        dbc.addEmployee(this, tempe2);       
        dbc.setAdmin(this, 2, true);
        System.out.println();
        
        //adding a student
        System.out.println("adding a student");
        Student temps = new Student("StudentName", 3);
        dbc.addStudent(this, temps);
        System.out.println();
        
        //adding a college
        System.out.println("adding a college");
        College tempc = new College("CollegeName", 1);
        dbc.addCollege(this, tempc);
        System.out.println();
        
        //adding a department
        System.out.println("adding a department");
        Department tempd = new Department("DepartmentName", 2);
        dbc.addDepartment(this, "CollegeName", tempd);
        System.out.println();
        
        //adding a major
        System.out.println("adding a major");
        Major tempm = new Major("MajorName");
        dbc.addMajor(this, "CollegeName", "DepartmentName", tempm);
        System.out.println();
        
        //adding two course
        System.out.println("adding two course");
        Course tempcc1 = new Course("CourseName1", 5);
        dbc.addCourse(this, "CollegeName", "DepartmentName", "MajorName", tempcc1);
        Course tempcc2 = new Course("CourseName2", 5);
        dbc.addCourse(this, "CollegeName", "DepartmentName", "MajorName", tempcc2);
        System.out.println();
        
        //adding a building
        System.out.println("adding a building");
        Building tempb = new Building("BuildingName", 100);
        dbc.addBuilding(this, tempb);
        System.out.println();
        
        //adding a room
        System.out.println("adding a room");
        Room tempr = new Room("RoomName", 30);
        dbc.addRoom(this, "BuildingName", tempr);
        System.out.println();
        
        
        LocalTime tempst = LocalTime.of(8, 0);
        LocalTime tempet = LocalTime.of(10, 0);
        
        //adding two sessions
        //the second one has a time conflict (aka both have same day, time, building, room)
        System.out.println("adding two sessions\nthe second one has a time conflict (aka both have same day, time, building, room)");
        Session tempss1 = new Session("01", 0, 1, true, tempb, tempr, tempst, tempet, tempcc1);
        Session tempss2 = new Session("02", 0, 1, true, tempb, tempr, tempst, tempet, tempcc1);
        
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "CourseName1", tempss1);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "CourseName1", tempss2);
        tempst = LocalTime.of(12, 0);
        tempet = LocalTime.of(14, 0);
        System.out.println();
        
        //adding a third session with no time conflict
        System.out.println("adding a third session with no time conflict");
        Session tempss3 = new Session("03", 0, 1, true, tempb, tempr, tempst, tempet, tempcc2);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "CourseName2", tempss3);
        System.out.println();
        
        //assuming that it was checked that this major exists
        System.out.println("assuming that it was checked that this major exists");
        sc.changeMajor(this, 3, "MajorName");
        System.out.println();
        
        //student hasn't paid but is trying to add
        System.out.println("student hasn't paid but is trying to add");
        sc.addSession(this, 3, tempss3);
        System.out.println();
        
        //assigning the student as paid 
        //and student adding the course
        System.out.println("assigning the student as paid \nand student adding the course");
        ac.studentPaid(this, 3, true);
        sc.addSession(this, 3, tempss3);
        System.out.println();
        
        //assigning a grade that's not in the students list
        System.out.println("assigning a grade that's not in the students list");
        ac.assignGrade(this, 3, tempss1, 'A');
        System.out.println();
        
        
        //assign a grade that's in the student's list
        System.out.println("assign a grade that's in the student's list");
        ac.assignGrade(this, 3, tempss3, 'A');
        System.out.println();
        
        //removing a session that doesn't exist
        System.out.println("removing a session that doesn't exist from the student's schedule");
        Session tempss5 = new Session("05", 0, 3, true, tempb, tempr, tempst, tempet, tempcc2);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "CourseName2", tempss5);
        sc.addSession(this, 3, tempss5);
        //dbc.getStudent(this, 3).studentProfile();
        sc.removeSession(this, 3, "abcdef");
        System.out.println();
        
        //removing a session that exists
        System.out.println("removing a session that exists in the student's schedule");
        tempst = LocalTime.of(16, 0);
        tempet = LocalTime.of(17, 0);
        Session tempss4 = new Session("05", 0, 1, true, tempb, tempr, tempst, tempet, tempcc2);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "CourseName2", tempss4);
        sc.addSession(this, 3, tempss4);    
        sc.removeSession(this, 3, "05");
        System.out.println();
        
        //student adding a course but doesn't have the prereq
        System.out.println("student adding a course but doesn't have the prereq");
        Course preReq1 = new Course("Prereq1", 1);
        preReq1.addPrereqCourse(tempss1.getCourse());
        dbc.addCourse(this, "CollegeName", "DepartmentName", "MajorName", preReq1);
        Session tempssp5 = new Session("05", 0, 6, true, tempb, tempr, tempst, tempet, preReq1);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "Prereq1", tempssp5);
        sc.addSession(this, 3, tempssp5);
        System.out.println();
        
        
        //student adding a course and has the prereq
        System.out.println("student adding a course and has the prereq");
        Course preReq2 = new Course("Prereq2", 1);
        preReq2.addPrereqCourse(tempss3.getCourse());
        dbc.addCourse(this, "CollegeName", "DepartmentName", "MajorName", preReq2);
        Session tempssp6 = new Session("05", 0, 6, true, tempb, tempr, tempst, tempet, preReq2);
        dbc.addSession(this, "CollegeName", "DepartmentName", "MajorName", "Prereq2", tempssp6);
        sc.addSession(this, 3, tempssp6);
        System.out.println();
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
            
    
    
        
   
}
