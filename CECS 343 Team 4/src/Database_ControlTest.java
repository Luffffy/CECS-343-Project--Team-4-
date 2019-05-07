/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Database_ControlTest {
    
    public static void main(String[]args)
    {
     
        Database db = new Database();
        System.out.println("\n \nMenu");
        Database_Control dbc = new Database_Control();
        Student_Control sc = new Student_Control();
        Employee e = new Employee( "Bob", 123456, 1000);
        dbc.addEmployee(db, e);
        
        int right = 123456;
        int wrong = 1234567;
        
        dbc.setAdmin(db, right, true);
        dbc.setAdmin(db, wrong, true);
        
        dbc.printIDs(db);
        
        System.out.println("Profile: " + 3);
        sc.printProfile(db, 3);
        
        
    }
    
    
}
