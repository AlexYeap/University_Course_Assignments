import java.util.ArrayList;

public class SeatList {
	private ArrayList<Seat> seats;

    public SeatList(ArrayList<Seat> seats) {
        this.seats = seats;
	}

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeat(ArrayList<Seat> seats) {
        this.seats = seats;
    }

}
