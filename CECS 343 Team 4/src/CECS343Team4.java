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

    static Scanner sc1 = new Scanner(System.in);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int loginput = 0;
        
        String password = "";
        String formatID = "";

        ArrayList<Integer> adminIDs = new ArrayList<>();
        
        int adminIDIncrement = 1;
        int studentIDIncrement = 500000001;
        final int ADMIN_ID_LIMIT = 500000000;
        final int STUDENT_ID_LIMIT = 999999999;
       
        // 3 possible interfaces
        /*
         * one for superuser
         * one for admin
         * one for student
         */
        do {

            System.out.println("Enter user ID. Enter a negative to terminate");

            loginput = sc.nextInt();
            
            // terminate program if negative value is inputted
            if (loginput < 0) {
                return;
            }
            

            // check if ID is superuser, admin, student, or invalid
            if (loginput == 0) {
                System.out.println("Enter password to gain super user priviledge.");

                sc.nextLine();
                password = sc.nextLine();

                // check if password matches
                if (password.compareTo("abcd") == 0) {
                    System.out.println("Welcome super user.");
                    
                    //display admin menu
                    superUserMenuDisplay();
                    
                    
                    
                    

                } else {
                    System.out.println("Invalid password returning to main login");
                }

            } else if (loginput > 0 && loginput <= ADMIN_ID_LIMIT) {
                System.out.println("Welcome admin");

                //create admin menu
                adminMenuDisplay();

            } else if (loginput > ADMIN_ID_LIMIT && loginput <= STUDENT_ID_LIMIT) {
                System.out.println("Welcome student");

                // create student menu
            } else {
                System.out.println("Invalid id recognized");
            }
        } while (loginput >= 0);
    }

    public static void superUserMenuDisplay(){
        System.out.println("1. Add University \n2. Add College \n3. Add Department \n4. \n5. Back");
        
        
        switch(sc1.nextInt()){
            case 1:
                System.out.println("Adding university test");
                break;
            case 2:
                System.out.println("Adding college test");
                break;
            case 3:
                System.out.println("Adding department test");
                break;
            case 4:
                System.out.println("Adding Student test");
                break;
            case 5:
                System.out.println("Going back to login.");
                return;
            default:
                System.out.println("Invalid menu item");
                superUserMenuDisplay();
                break;
        }  
    }
    public static void adminMenuDisplay() {
        System.out.println("1. Add University \n2. Add College \n3. Add Department \n4.");
    }

    public static void studentMenuDisplay() {
        System.out.println("1. \n2. \n3. \n4.");
    }

    

    public static void printIDs(ArrayList<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            System.out.println("ID#: " + String.format("%09d", ids.get(i)));
        }
    }
}


// formatID = String.format("%09d", loginput);   // convert user input into string and format for 9 digits
