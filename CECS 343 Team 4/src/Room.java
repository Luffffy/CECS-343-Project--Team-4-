import java.util.ArrayList;


public class Room {
    private String roomName;
    private int occupancyLimit;
    private ArrayList <Session> sessions = new ArrayList();
    
    public Room(String name, int limit) {
        roomName = name;
        occupancyLimit = limit;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String name) {
        roomName = name;
    }
    
    public int getOccupancyLimit() {
        return occupancyLimit;
    }
    
    public void setOccupancyLimit(int limit) {
        occupancyLimit = limit;
    }
    
    public boolean isEmpty() {
        return sessions.isEmpty();
    }
    
    public void addSession(Session session) {
        sessions.add(session);
    }
    
    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public ArrayList<Session> getSessionList() {
        return sessions;
    }
    
}
