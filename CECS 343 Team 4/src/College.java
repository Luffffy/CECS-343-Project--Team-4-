import java.util.ArrayList;

public class College {
    private String collegeName;
    private int deanID;
    private ArrayList <Department> departments = new ArrayList();
    
    public College(String name, int ID) {
        collegeName = name;
        deanID = ID;
    }
    
    public boolean isEmpty() {
        return departments.isEmpty();
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }
    
    public void removeDepartment(Department department) {
        departments.remove(department);
    }
    
    public ArrayList<Department> getDepartmentList() {
        return departments;
    }
    
    public String getDepartments() {
        if(departments.isEmpty()) {
            return "No Departments";
        } else {
            String s = "";
            for(Department department: departments){
                s += department.getDepartmentName() + "\n";
            }
            return s;
        }
    }
    
    public void setCollegeName(String name) {
        collegeName = name;
    }
    
    public String getCollegeName() {
        return collegeName;
    }    
    
    public void setDeanID(int ID) {
        deanID = ID;
    }
    
    public int getDeanID() {
        return deanID;
    }
    
    public Department contains(String d) {
        Department temp = null;
        for(Department department : departments) {
            if(department.getDepartmentName().equals(d)) {
                temp = department;
            }
        }
        return temp;
    }
}
