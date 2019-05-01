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
    private Map<Integer, Student> Students;
    private Map<Integer, Employee> Employees; 
    
    public Database()
    {
        uni = new University("University of Geeks");
    }
    
    public University getUni()
    {
        return uni;
    }
    
    public Map getStudents()
    {
        return Students;
    }
    
    public Map getEmployees()
    {
        return Employees;
    }
    
    
            
    
    
        
   
}
