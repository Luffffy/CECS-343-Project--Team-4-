import java.util.ArrayList;

public class Building {
    private String buildingName;
    private int occupancyLimit;
    private ArrayList <String> rooms = new ArrayList();
    
    public Building(String name, int limit) {
        occupancyLimit = limit;
        buildingName = name;
    }
    
    public void addRoom(String room) {
        rooms.add(room);
    }
    
    public void removeRoom(String room) {
        rooms.remove(room);
    }
    
    public ArrayList<String> getRoomList() {
        return rooms;
    }
    
    public String getRooms() {
        if(rooms.isEmpty()) {
            return "No Rooms";
        } else {
            String s = "";
            for(String room: rooms){
                s += room + "\n";
            }
            return s;
        }
    }
    
    public int getOccupancyLimit() {
        return occupancyLimit;
    }
    
    public void setOccupancyLimit(int limit) {
        occupancyLimit = limit;
    }
    
    public String getBuildingName() { 
        return buildingName;
    }
    
    public void setBuildingName(String name) {
        buildingName = name;
    }
}
