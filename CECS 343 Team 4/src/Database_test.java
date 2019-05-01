/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
import java.util.*;
public class Database_test {
    
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        String inputs;
        //int inputi = in.nextInt();
        Database DB = new Database();
        
        College tempc = new College("Engineering", 12345);
        System.out.println("adding a college (Engineering)");
        Database_Control DBc = new Database_Control();  
        DBc.addCollege(DB, tempc);
        inputs = in.next();
        System.out.println(DBc.getCollege(DB,inputs).getCollegeName());
        System.out.println(DBc.getCollege(DB,inputs).getDeanID());
        
        System.out.println("print uni");
        
        System.out.println(DB.getUni().getUniversityName());
    }
}
