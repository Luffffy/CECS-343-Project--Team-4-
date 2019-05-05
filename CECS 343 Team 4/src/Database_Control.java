import java.time.LocalTime;
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
    
    public Session getSession(Database db, String c, String d, String m, String cc, String ss)
    {
        Session temp = db.getUni().contains(c).contains(d).contains(m).contains(cc).contains(ss);
        return temp;
    }
    
    public Building getBuilding(Database db, String building)
    {
        Building temp = db.getBuilding(building);
        return temp;
    }
    
    public Room getRoom(Database db, String building, String room)
    {
        Room temp = db.getBuilding(building).contains(room);
        return temp;
    }
    
    public void addCollege(Database db, College c)
    {
        if(db.getUni().getCollegeList().size() < 10) {
            db.getUni().addCollege(c);
            System.out.println("College has been added to the Database");
        } else {
            System.out.println("University can't have more than 10 Colleges");
        }
    }
    
    public void addDepartment(Database db, String college, Department d)
    {
        if(db.getUni().contains(college).getDepartmentList().size() < 30) {
            db.getUni().contains(college).addDepartment(d);
            System.out.println("Department has been added to the Database");
        } else {
            System.out.println("College can't have more than 30 Departments");
        }
    }
    
    public void addMajor(Database db, String college, String department, Major m)
    {
       if(db.getUni().contains(college).contains(department).getMajorList().size() < 50) {
            db.getUni().contains(college).contains(department).addMajor(m);
            System.out.println("Major has been added to the Database");
        } else {
            System.out.println("Department can't have more than 50 majors");
        }
    }
    
    public void addCourse(Database db, String college, String department, String major, Course c)
    {
        if(db.getUni().contains(college).contains(department).contains(major).getCourseList().size() < 100) {
            db.getUni().contains(college).contains(department).contains(major).addCourse(c);
            System.out.println("Course has been added to the Database");
        } else {
            System.out.println("Major can't have more than 100 courses");
        }
    }
    
    public void addSession(Database db, String college, String department, String major, String course, Session s)
    {
        if(!db.getUni().contains(college).contains(department).contains(major).contains(course).getSessionList().isEmpty())
        {
            for(Session session: db.getUni().contains(college).contains(department).contains(major).contains(course).getSessionList())
            {
                if(timeConflict(session, s))
                {
                    System.out.println("Session cannot be added because it has a time conflict with another existing session");
                    return;
                }
            }
        }
        if(db.getUni().contains(college).contains(department).contains(major).contains(course).getSessionList().size() < 100) {
            db.getUni().contains(college).contains(department).contains(major).contains(course).addSession(s);
            System.out.println("Session has been added to the Database");
        } else {
            System.out.println("Course can't have more than 30 Sessions");
        }
    }
    
    public void addBuilding(Database db, Building building)
    {
        if(!db.getBuildings().containsKey(building.getName()))
        {
            System.out.println("Building added to the Database");
            db.getBuildings().put(building.getName(), building);
        }
        else
        {
            System.out.println("Building already exists");
        }
    }
    
    public void addRoom(Database db, String building, Room room )
    {
        if(db.getBuildings().containsKey(building))
        {
            System.out.println("Room has been added to " + building);
            db.getBuilding(building).getRoomList().add(room);
        }
        else
        {
            System.out.println("Building does not exist");
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
            System.out.println(c + " has been deleted from the database");
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
            System.out.println(d + " has been deleted from the database");
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
            System.out.println(m + " has been deleted from the database");
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
            System.out.println(cc + " has been deleted from the database");
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
    
    public void removeBuilding(Database db, String building)
    {
        if(db.getBuilding(building).isEmpty())
        {
            System.out.println(building + " Building has been removed from the Database");
            db.getBuildings().remove(building);
        }
        else
        {
            System.out.println(building + " Building cannot be removed because it has rooms");
        }
    }
    
    public void removeRooms(Database db, String building, String room)
    {
        if(db.getBuilding(building).contains(room).isEmpty())
        {
            System.out.println("Room " + room + " has been removed from the " + building + " Building" );
            db.getBuilding(building).removeRoom(db.getBuilding(building).contains(room));
        }
        else
        {
            System.out.println("Room " + room + " cannot be removed because it has sessions");
        }
    }
    
    public void addStudent(Database db, Student s)
    {        
        //System.out.println("Student id: " + s.getStudentID());
        if(!db.studentExists(s.getStudentID()))
        {
            System.out.println("Student added to the Database");
            db.getStudents().put(s.getStudentID(), s);
        }
        else
        {
            System.out.println("Student already exists");
        }
    }
    
    public void addEmployee(Database db, Employee e)
    {
        //System.out.println("employee id: " + e.getID());
        if(!db.employeeExists(e.getID()))
        {
            System.out.println("Employee added to the Database");
            db.getEmployees().put(e.getID(), e);
        }
        else
        {
            System.out.println("Employee already exists");
        }
    }
    
    public void setAdmin(Database db, int eID, boolean input)
    {
        if(input)
        {
            if(db.employeeExists(eID))
            {
                db.getEmployee(eID).setAdmin(input);
                System.out.println("Admin has been set for: " + db.getEmployee(eID).toString());
            }
            else
            {
                System.out.println("Employee does not exist");
            }
        }
        else
        {
            if(db.employeeExists(eID))
            {
                db.getEmployee(eID).setAdmin(input);
                System.out.println("Admin has been removed for: " +  db.getEmployee(eID).toString());
            }
            else
            {
                System.out.println("Employee does not exist");
            }
        }
    }
    
    public Student getStudent(Database db, int sID)
    {
        return db.getStudent(sID);
    }
    
    public Employee getEmployee(Database db, int eID)
    {
        return db.getEmployee(eID);
    }
    
    public void removeStudent(Database db, int sID)
    {
        if(db.getStudent(sID).isEmpty())
        {
            System.out.println(db.getStudent(sID).toString() + " has been removed from the database");
            db.getStudents().remove(sID);
        }
        else
        {
            System.out.println("This student cannot be removed because they have sessions added");
        }
    }
    
    public void removeEmployee(Database db, int eID)
    {
        if(db.getEmployee(eID).isEmpty())
        {
            System.out.println(db.getEmployee(eID).toString() + " has been removed from the database");
            db.getEmployees().remove(eID);
        }
        else
        {
            System.out.println("This employee cannot be removed because they have sessions added");
        }
    }
    
    public boolean studentExists(Database db, int sID)
    {
        return db.studentExists(sID);
    }
    
    public boolean employeeExists(Database db, int eID)
    {
        return db.employeeExists(eID);
    }
    
    public void printIDs(Database db)
    {
        db.printIDs();
    }
    
    public boolean timeConflict(Session a, Session b)
    {
        LocalTime aS = a.getStartTime();
        LocalTime aE = a.getEndTime();
        LocalTime bS = b.getStartTime();
        LocalTime bE = b.getEndTime();
        
        if(a.getBuildingName().equals(b.getBuildingName()))
        {
            if(a.getRoomName().equals(b.getRoomName()))
            {
                if(a.getDay() == b.getDay())
                {
                    
                    if(aS.equals(bS) && aE.equals(bE))
                    {
                        //System.out.println("Time Conflict A and B start and end at the same Time");
                        return true;
                    }
                    if(aS.isBefore(bS) && aE.isAfter(bS))
                    {
                        //System.out.println("Time conflict B starts between A");
                        return true;
                    }
                    if(bS.isBefore(aS) && bE.isAfter(aS))
                    {
                       //System.out.println("Time conflict A starts between B");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
