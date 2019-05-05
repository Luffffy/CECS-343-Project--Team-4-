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
        Employee temp = new Employee("Name", 0, 0);
        Employees.put(temp.getID(),temp);
        
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
        if(getStudents().containsKey(sID))
        {
            System.out.println("Student is found");
            return (Student) getStudents().get(sID);
        }
        System.out.println("Student not found");
        return null;
    }
    
    public Employee getEmployee( int eID)
    {
        if(getEmployees().containsKey(eID))
        {
            System.out.println("Employee is found");
            return (Employee) getEmployees().get(eID);
        }
        System.out.println("Employee not found");
        return null;
    }
    
    public Building getBuilding(String name)
    {
        if(getBuildings().containsKey(name))
        {
            System.out.println("Building is found");
            return (Building) getBuildings().get(name);
        }
        System.out.println("Building is not found");
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
    
    
    
    
            
    
    
        
   
}
