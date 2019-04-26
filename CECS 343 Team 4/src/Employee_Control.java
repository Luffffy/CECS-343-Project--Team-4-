
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Employee_Control {
    
    public String checkClassConflict(Employee e, Course c)
    {
        boolean canTeach = true;
        ArrayList<Course> temp = e.getTeachingSchedule();
        for(int i = 0; i < temp.size(); i++)
        {
            if(temp.get(i).getDay().equals(c.getDay()) && temp.get(i).getTime().equals(c.getTime))
            {
                System.out.println("Professor has time Conflict");
                canTeach = false;
            }
        }
        if(canTeach){
            e.addClass(c);
            return "Class has been added";
        }
        else
            return "Professor has time Conflict.";
        
    }
}
