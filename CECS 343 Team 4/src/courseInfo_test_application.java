import java.util.ArrayList;

/**
 *
 * @author chealyTahir
 */
public class courseInfo_test_application {
    public static void main(String[] args) { 
        courseInfo Physic400Course = new courseInfo("Physic400", 1400);
        Physic400Course.addPrereCourse("GE100");
        Physic400Course.addPrereCourse("Math100");
        Physic400Course.addPrereCourse("English100");
        Physic400Course.addPrereCourse("Physic100");
        Physic400Course.addPrereCourse("Physic200");
        Physic400Course.addPrereCourse("Physic300");
        
        System.out.println("prerequisite course for Physic400: ");
        ArrayList<String> physicList = new ArrayList<>();
        
        physicList = Physic400Course.getPrerequisiteCourseList();
        
        for (String prerequisiteCourse : physicList) {
            System.out.print(prerequisiteCourse + " ");
        }
        System.out.println();
        
        System.out.println("course name and ID: " + Physic400Course.getCourseName()
                + ", " + Physic400Course.getCourseID());
    }
}
