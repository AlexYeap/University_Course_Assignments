import java.util.ArrayList;

public class Theatre {
    private String theaterName;
    private ArrayList<Movie> movies;
    private ArrayList<Showroom> showRooms;

    public Theatre(){
        movies = new ArrayList<>();
        showRooms = new ArrayList<>();
    }

    public void setTheatreName(String theaterName){
        this.theaterName = theaterName;
    }

    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }

    public void setShowRooms(ArrayList<Showroom> showRooms){
        this.showRooms = showRooms;
    }

    public String getTheaterName(){
        return this.theaterName;
    }

    public ArrayList<Movie> getMovies(){
        return this.movies;
    }

    public ArrayList<Showroom> geShowrooms(){
        return this.showRooms;
    }
}
