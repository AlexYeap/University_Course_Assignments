public class Seat {
    private String seatNumber;
    private int available;
    private int theaterID;
    private int roomID;

    public Seat(){}

    public String getSeatNumber(){
        return seatNumber;
    }

    public int getAvailability(){
        return available;
    }

    public int getTheaterID(){
        return theaterID;
    }

    public int getRoomID(){
        return roomID;
    }

    public void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }

    public void setAvailability(int available){
        this.available = available;
    }

    public void setTheatreID(int theatreID){
        this.theaterID = theatreID;
    }

    public void setRoomID(int roomID){
        this.roomID = roomID;
    }
}
