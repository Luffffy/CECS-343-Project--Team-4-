import java.util.*;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Student_Control {
      
    public void addSession(Database db, int sID, Session session)
    {
        Student student = db.getStudent(sID);
        if(checkTuition(student))
        {
            if(tookPrereqs(db, student, session))
            {
                if(student.studentTotalUnits() <= 20 && (student.studentTotalUnits() + session.getUnits()) <= 20)
                {
                    ArrayList<Session> temp = student.getSessionList();
                    boolean conflict = false;
                    for(Session s: temp)
                    {
                        if(timeConflict(s, session))
                        {
                            System.out.println("Cannot add session because it has a time conflict with another session");
                            conflict = true;
                        }
                    }
            
                    if(!conflict)
                    {
                        student.addSession(session);
                        session.addStudent(student);
                        System.out.println("Session has been added to the Student's schedule");
                    }
                }
                else
                {
                    System.out.println("Student cannot go over 20 units total");
                }
            }
            else
            {
                System.out.println("Student has not taken the prerequisites for this course");
            }
        }
    }
    
    public void removeSession(Database db, int sID, String s)
    {
        Student student = db.getStudent(sID);
        boolean canRemove = false;
                 
        if(!student.getSessionList().isEmpty())
        {
            ArrayList<Session> temp = student.getSessionList();
            Session temps = null;
            for(Session session: temp)
            {
                if(session.getSessionNumber().equals(s))
                { 
                  temps = session;
                  canRemove = true;  
                }
            }
            if(canRemove)
            {
                db.getStudent(sID).removeSession(temps);
                temps.removeStudent(student);
                System.out.println("Session has been removed from the Student's schedule");
            }
            else
            {
                System.out.println("The session is not in the Student's schedule");
            }
        }
        else
        {
            System.out.println("There are no sessions to be removed");
        }
    }
    public void changeMajor(Database db, int sID, String m)
    {
        db.getStudent(sID).changeMajor(m);
        System.out.println("Student has changed their major to " + m);
    }
    
    public boolean checkTuition(Student s)
    {
        if(s.getPaid())
        {
            System.out.println("Student has paid their tuition");
            return true;
        }
        else
        {
            System.out.println("Student has not paid their tuition so they cannot add a session");
            return false;
        }
    }
    
    public boolean tookPrereqs(Database db, Student student, Session session)
    {
        
        int preReqCount = session.getCourse().getPrerequisiteCourseList().size();
        int count = 0;
        ArrayList<Pair> takenCourses = student.getTakenCoursesList();
        for(Pair p: takenCourses)
        {
            if(session.getCourse().getPrerequisiteCourseList().contains(p.getCourse()))
            {
                count++;
            }
        }
        return count == preReqCount;
        
    }
    
    public void printProfile(Database db, int sID)
    {
        db.getStudent(sID).studentProfile();
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
