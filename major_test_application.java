/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chealyTahir
 */
public class major_test_application {
    public static void main(String[] args) {
        System.out.println("major_test_application");
        
        major chem_major = new major("chemistry", "chem1");
        chem_major.add_MajorCourse("chem2");
        chem_major.add_MajorCourse("chem3");
        chem_major.add_MajorCourse("chem4");
        chem_major.add_MajorCourse("chem5");
        chem_major.add_MajorCourse("chem6");
        chem_major.add_MajorCourse("chem7");
        
        chem_major.print_MajorCourses(chem_major.get_majorName());
    }
}
