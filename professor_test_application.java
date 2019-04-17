/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chealyTahir
 */
public class professor_test_application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = null;
        System.out.println("hello testing");
        
        professor mr_A = new professor("0Mr_A", 12354);
        mr_A.set_proSchedule("chemistry1", "M_W", "11:00 am", "B_A:r100");
        str = mr_A.get_courseSchedule("chemistry1");
        System.out.println(str);
    }    
}
