/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Database_Control {
    
    public void addCollege(Database db, College c)
    {
        db.getUni().addCollege(c);
    }
    
    public College getCollege(Database db, String c)
    {
        College temp = db.getUni().contains(c);
        return temp;
    }
    
    public Department getDepartment(Database db, String c, String s)
    {
        Department temp = db.getUni().contains(c).contains(s);
        return temp;
    }
    
    public void addDepartment(Database db, Department d)
    {
        db.getUni().getCollegeList();
    }
}
