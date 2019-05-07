import java.time.*;
import java.util.*;


public class Admin_Control {
    
    public void assignGrade(Database db, int sID, Session s, char grade)    
    {
        ArrayList<Session> temp = db.getStudent(sID).getSessionList();
        for(int i = 0; i < temp.size(); i++)
        {
            if(temp.get(i).getSessionNumber().equals(s.getSessionNumber()))
            {
                System.out.println("test");
                db.getStudent(sID).addTakenCourse(s, grade);
                System.out.println("Assigned a " + grade + " to " + s.getCourse().getCourseName() + " for " + db.getStudent(sID).toString());
                return;
            }
        }
        System.out.println("Session is not in the Student's schedule so a grade cannot be added");
        
        /*
        if(db.getStudent(sID).getSessionList().contains(s))
        {
            db.getStudent(sID).addTakenCourse(s, grade);
            System.out.println("Assigned a " + grade + " to " + s.getCourse().getCourseName() + " for " + db.getStudent(sID).toString());
        }
        else
        {
            System.out.println("Session is not in the Student's schedule so a grade cannot be added");
        }
*/
    }
    
    public void studentPaid(Database db, int sID, boolean paid)
    {
        db.getStudent(sID).setTuition(paid);
        System.out.println("Student is now toggled as Paid");
    }
    
    public void timeConflict(Session a, Session b)
    {
        LocalTime aS = a.getStartTime();
        LocalTime aE = a.getEndTime();
        LocalTime bS = b.getStartTime();
        LocalTime bE = b.getEndTime();
        
        if(aS.isBefore(bS) && aE.isAfter(bS))
            System.out.println("Time conflict B starts between A");
        if(bS.isBefore(aS) && bE.isAfter(aS))
            System.out.println("Time conflict A starts between B");
    }
}
