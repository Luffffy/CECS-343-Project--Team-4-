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
      
    public String checkTuition(Student s, Session c)
    {
        if(s.getPaid())
        {
            s.addSession(c);
            return "Class has been added";
        }
        else
        {
            return "Student has not paid their tuition";
        }
    }
}
