import java.util.ArrayList;

public class Showroom {
    private int roomID;
    private String roomName;
    private String theaterName;
    private ArrayList<Seat> seats;
    private ArrayList<ShowTime> showTimes;

    public Showroom(){
        seats = new ArrayList<>();
        showTimes = new ArrayList<>();
    }

    public int getRoomID(){
        return roomID;
    }

    public String getRoomName(){
        return roomName;
    }

    public String getTheaterName(){
        return theaterName;
    }

    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public ArrayList<ShowTime> getShowTimes(){
        return showTimes;
    }

    public void setRoomID(int roomID){
        this.roomID = roomID;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public void setTheaterName(String theaterName){
        this.theaterName = theaterName;
    }

    public void setSeats(ArrayList<Seat> seats){
        this.seats = seats;
    }

    public void setShowTimes(ArrayList<ShowTime> showtimes){
        this.showTimes = showtimes;
    }
}
