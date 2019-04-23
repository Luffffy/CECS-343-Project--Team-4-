/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chealyTahir
 */
public class Student_class_test_application {
    public static void main(String[] args) { 
        Student studentA = new Student("studentA", 12345);
        studentA.addCourse("Art101");
        studentA.addCourse("Biologh102");
        studentA.addCourse("Math110");
        studentA.selectMajof("Engineering");
        
        studentA.printStudentCourses();
        studentA.studentProfile();        
    }
}
