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
        Department temp = db.getUni().contains(c).contains(d);
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
        if(db.getUni().getCollegeList().size() < 10) {
            db.getUni().addCollege(c);
            System.out.println("College has been added");
        } else {
            System.out.println("University can't have more than 10 Colleges");
        }
    }
    
    public void addDepartment(Database db, String college, Department d)
    {
        if(db.getUni().contains(college).getDepartmentList().size() < 30) {
            db.getUni().contains(college).addDepartment(d);
            System.out.println("Department has been added");
        } else {
            System.out.println("College can't have more than 30 Departments");
        }
    }
    
    public void addMajor(Database db, String college, String department, Major m)
    {
       if(db.getUni().contains(college).contains(department).getMajorList().size() < 50) {
            db.getUni().contains(college).contains(department).addMajor(m);
            System.out.println("Major has been added");
        } else {
            System.out.println("Department can't have more than 50 majors");
        }
    }
    
    public void addCourse(Database db, String college, String department, String major, Course c)
    {
        if(db.getUni().contains(college).contains(department).contains(major).getCourseList().size() < 100) {
            db.getUni().contains(college).contains(department).contains(major).addCourse(c);
            System.out.println("Course has been added");
        } else {
            System.out.println("Major can't have more than 100 courses");
        }
    }
    
    public void addSession(Database db, String college, String department, String major, String course, Session s)
    {
        if(db.getUni().contains(college).contains(department).contains(major).contains(course).getSessionList().size() < 100) {
            db.getUni().contains(college).contains(department).contains(major).contains(course).addSession(s);
            System.out.println("Session has been added");
        } else {
            System.out.println("Course can't have more than 30 Sessions");
        }
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
        if(db.getUni().contains(c).contains(d).isEmpty() == false)
        {
            System.out.println("Can't remove");
        }
        else
        {
            db.getUni().contains(c).removeDepartment(db.getUni().contains(c).contains(d));
            System.out.println(d + " has been deleted");
        }
    }
    
    public void removeMajor(Database db, String c, String d, String m)
    {
        if(db.getUni().contains(c).contains(d).contains(m).isEmpty() == false)
        {
            System.out.println("Can't remove");
        }
        else
        {
            db.getUni().contains(c).contains(d).removeMajor(db.getUni().contains(c).contains(d).contains(m));
            System.out.println(m + " has been deleted");
        }
    }
    
    public void removeCourse(Database db, String c, String d, String m, String cc)
    {
        if(db.getUni().contains(c).contains(d).contains(m).contains(cc).isEmpty() == false)
        {
            System.out.println("Can't remove");
        }
        else
        {
            db.getUni().contains(c).contains(d).contains(cc).removeCourse(db.getUni().contains(c).contains(d).contains(m).contains(cc));
            System.out.println(cc + " has been deleted");
        }
    }
    
    public void removeSession(Database db, String c, String d, String m, String cc, String s)
    {
        if(db.getUni().contains(c).contains(d).contains(m).contains(cc).contains(s).isEmpty() == false)
        {
            System.out.println("Can't remove");
        }
        else
        {
            db.getUni().contains(c).contains(d).contains(cc).contains(s).removeSession(db.getUni().contains(c).contains(d).contains(m).contains(cc).contains(s));
            System.out.println(s + " has been deleted");
        }
    }
    
    
    public Student getStudent(Database db, int sID)
    {
        if(db.getStudents().containsKey(sID))
        {
            return (Student) db.getStudents().get(sID);
        }
        return null;
    }
    
    public Employee getEmployee(Database db, int eID)
    {
        if(db.getEmployees().containsKey(eID))
        {
            return (Employee) db.getEmployees().get(eID);
        }
        return null;
    }
    
    public boolean studentExists(Database db, int sID)
    {
        return db.getStudents().containsKey(sID);
    }
    
    public boolean employeeExists(Database db, int eID)
    {
        return db.getEmployees().containsKey(eID);
    }
}
