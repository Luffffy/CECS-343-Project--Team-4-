import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class hashmap_test_application {
 public static void main(String[] args) {  
      
        System.out.println("Print out intitial information in Database: ");
        hashmapDatabase dataObject = new hashmapDatabase();
        dataObject.print_major_Hashmap();
        dataObject.print_prereCourse_Hashmap();
        dataObject.print_professor_Hashmap();
        System.out.println();
        
        System.out.println("Database of major object after add on Chemistry major: ");
        Major chem_major = new Major("Chemistry");
        chem_major.add_MajorCourse("chem2");
        chem_major.add_MajorCourse("chem3");
        chem_major.add_MajorCourse("chem4");
        chem_major.add_MajorCourse("chem5");
        chem_major.add_MajorCourse("chem6");
        chem_major.add_MajorCourse("chem7");     
        dataObject.add_major_Hashmap(chem_major);
        dataObject.print_major_Hashmap();
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFram_test1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFram_test1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFram_test1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFram_test1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HashMap_Database_UI().setVisible(true);
            }
        });
        
        /* Create and display the form */
/*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_UI().setVisible(true);
            }
        }); */
        
    }
}
