/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class College {
    private String collegeName;
    private int deanID;
    
    public College(String name, int ID) {
        collegeName = name;
        deanID = ID;
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
}
