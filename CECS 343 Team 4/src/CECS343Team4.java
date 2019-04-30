/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
import java.util.ArrayList;
import java.util.Scanner;
public class CECS343Team4 {

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in);   
    int input = 0;
    String formatted = "";
    boolean admin = false;
    
        // 3 possible interfaces
        /*
         * one for superuser
         * one for admin
         * one for student
         */
        System.out.println("Enter user ID");
        
        input = sc.nextInt();       // get user input for id
        //formatted = String.format("%09d", input);   // convert user input into string and format for 9 digits
                                                                               
        //System.out.println(formatted);
        
        
        // check if ID is superuser, admin, student, or invalid
        if(input == 0){
            System.out.println("Enter password to gain super user priviledge.");
        }
        else if(input > 0 && input <= 500000000){
            System.out.println("Welcome admin");
        }
        else if(input > 500000000 && input <= 999999999){
            System.out.println("Welcome student");
        }
        else{
            System.out.println("Invalid id recognized");
        }       
    }
}
