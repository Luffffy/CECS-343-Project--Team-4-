import java.util.ArrayList;
/**
 *
 * @author chealyTahir
 */
public class Student_class_test_application {
    public static void main(String[] args) { 
        Student studentA = new Student("studentA", 12345);
        studentA.addCourse("Art101", 3);
        studentA.addCourse("Biologh102", 4);
        studentA.addCourse("Math110", 4);
        studentA.selectMajof("Engineering");
        
        System.out.println("get student course from ArrayList: ");
        ArrayList<String> courseList = new ArrayList();
        courseList = studentA.getCourseList();
        for (String course : courseList) {
            System.out.print (course + " ");
        }
        System.out.println();
        
        studentA.studentProfile(); 
        System.out.println();
    }
}
