public class Movie{
    private int movieID;
    private String movieName;
    private String releaseDate;
    private boolean released;
    private String  theaterName;
    private String roomName;

    public Movie(){

    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public void setTheaterName(String theaterName){
        this.theaterName = theaterName;
    }

    public int getMovieID(){
        return movieID;
    }

    public String getMovieName(){
        return movieName;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public boolean getReleased(){
        return released;
    }

    public String getTheaterName(){
        return theaterName;
    }

    public String getRoomName(){
        return roomName;
    }
}