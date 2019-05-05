import java.util.ArrayList;

public class Building {
    private String buildingName;
    private int occupancyLimit;
    private int totalOccupancy;
    private ArrayList <Room> rooms = new ArrayList();
    
    public Building(String name, int limit) {
        occupancyLimit = limit;
        buildingName = name;
        totalOccupancy = 0;
    }
    
    public String getName()
    {
        return buildingName;
    }
    public boolean isEmpty() {
        return rooms.isEmpty();
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
        totalOccupancy += room.getOccupancyLimit();
    }
    
    public void removeRoom(Room room) {
        rooms.remove(room);
        totalOccupancy -= room.getOccupancyLimit();
    }
    
    public ArrayList<Room> getRoomList() {
        return rooms;
    }
    
    public String getRooms() {
        if(rooms.isEmpty()) {
            return "No Rooms";
        } else {
            String s = "";
            for(Room room: rooms){
                s += room.getRoomName() + "\n";
            }
            return s;
        }
    }
    
    public Room contains(String s) {
        Room temp = null;
        for(Room room : rooms) {
            if(room.getRoomName().equals(s)) {
                temp = room;
            }
        }
        return temp;
    }
    
    public int getOccupancyLimit() {
        return occupancyLimit;
    }
    
    public void setOccupancyLimit(int limit) {
        occupancyLimit = limit;
    }
    
    public int getTotalOccupancy() {
        return totalOccupancy;
    }
    
    public String getBuildingName() { 
        return buildingName;
    }
    
    public void setBuildingName(String name) {
        buildingName = name;
    }
}
