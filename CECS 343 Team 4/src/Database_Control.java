import java.util.*;
public class Database_Control {
    
    public void addInfo()
    {
        
    }
    public College getCollege(Database db, String c)
    {
        College temp = db.getUni().contains(c);
        return temp;
    }
    
    public Department getDepartment(Database db, String c, String d)
    {
        Department temp = db.getUni().contains(c).contains(s);
        return temp;
    }
    
    public Major getMajor(Database db, String c, String d, String m)
    {
        Major temp = db.getUni().contains(c).contains(d).contains(m);
        return temp;
    }
    
    public Course getCourse(Database db, String c, String d, String m, String cc)
    {
        Course temp = db.getUni().contains(c).contains(d).contains(m).contains(cc);
        return temp;
    }
    
    public void addCollege(Database db, College c)
    {
        db.getUni().addCollege(c);
    }
    
    public void addDepartment(Database db, Department d)
    {
        
    }
    
    public void addMajor(Database db)
    {
       
    }
    
    public void addCourse(Database db)
    {
        
    }
    
    public void removeCollege(Database db, String c)
    {
        
        if(db.getUni().contains(c).isEmpty() == false)
        {
            System.out.println("Can't remove");
        }
        else
        {
            db.getUni().removeCollege(db.getUni().contains(c));
            System.out.println(c + " has been deleted");
        }
    }
    
    public void removeDepartment(Database db, String c, String d)
    {
        
    }
    
    public void removeMajor(Database db, String c, String d, String m)
    {
        
    }
    
    public void removeCourse(Database db, String c, String d, String m, String cc)
    {
        
    }
    
    
    
}
