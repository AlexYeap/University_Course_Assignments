import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageData {

    private Connection dbConnection;
    
    public ManageData(){
        connectToDatabase();
    }

    /**
	 * Opens a connection to the database,
	 */
	public void connectToDatabase(){	
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/THEATER", "student", "ensf480");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes a connection to the database
	 */
	public void close() {
		try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public ArrayList<Movie> getEarlyMovieNews(){
		ArrayList<Movie> earlyMovieNews = new ArrayList<>();
		ResultSet data;

		try{
			Statement statement = dbConnection.createStatement();
			data = statement.executeQuery("SELECT * FROM MOVIES WHERE released = 0");

			while(data.next()){
				Movie movie = new Movie();
				movie.setMovieName(data.getString("movie_name"));
				movie.setReleaseDate(data.getString("releaseDate"));
				movie.setTheaterName(data.getString("theater_name"));
				earlyMovieNews.add(movie);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return earlyMovieNews;
	}

	public ArrayList<Movie> getMovies(){
		ArrayList<Movie> movies = new ArrayList<>();
		ResultSet data;

		try{
			Statement statement = dbConnection.createStatement();
			data = statement.executeQuery("SELECT * FROM MOVIES WHERE released = 1");

			while(data.next()){
				Movie movie = new Movie();
				movie.setMovieName(data.getString("movie_name"));
				movie.setReleaseDate(data.getString("releaseDate"));
				movie.setTheaterName(data.getString("theater_name"));
				movies.add(movie);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return movies;
	}

	public ArrayList<Movie> getMoviesInTheatre(String theatreName){
		ArrayList<Movie> movies = new ArrayList<>();
		ResultSet data;

		try{
			String query = "SELECT * FROM MOVIES WHERE theater_name = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, theatreName);
			data = statement.executeQuery();

			while(data.next()){
				Movie movie = new Movie();
				movie.setMovieName(data.getString("movie_name"));
				movie.setReleaseDate(data.getString("releaseDate"));
				movie.setTheaterName(data.getString("theater_name"));
				movies.add(movie);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return movies;
	}

	public ArrayList<Theatre> getTheaters(){
		ArrayList<Theatre> theaters = new ArrayList<>();
		ResultSet data;

		try{
			Statement statement = dbConnection.createStatement();
			data = statement.executeQuery("SELECT * FROM THEATERS");

			while(data.next()){
				Theatre theatre = new Theatre();
				theatre.setTheatreName(data.getString("theater_name"));
				theatre.setMovies(getMoviesInTheatre(theatre.getTheaterName()));
				theaters.add(theatre);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return theaters;
	}

	public ArrayList<Theatre> getTheatersForMovie(String movie){
		ArrayList<Theatre> theaters = new ArrayList<>();
		ResultSet data;

		try{
			/* 
			Statement statement = dbConnection.createStatement();
			data = statement.executeQuery("SELECT * FROM THEATERS WHERE theater_name IN (SELECT theater_name FROM MOVIES WHERE movie_name = ${movie})");
			*/
			String query = "SELECT * FROM THEATERS WHERE theater_name IN (SELECT theater_name FROM MOVIES WHERE movie_name = ?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, movie);
			data = statement.executeQuery();

			while(data.next()){
				Theatre theatre = new Theatre();
				theatre.setTheatreName(data.getString("theater_name"));
				theaters.add(theatre);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return theaters;
	}

	public ArrayList<Showroom> getShowRooms(String theater_name, String movie_name){
		ArrayList<Showroom> showRooms = new ArrayList<>();
		ResultSet data;

		try{
			String query = "SELECT * FROM SHOW_ROOMS WHERE theater_name = ? AND room_id IN (SELECT room_id FROM MOVIES WHERE movie_name = ?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, theater_name);
			statement.setString(2, movie_name);
			data = statement.executeQuery();

			while(data.next()){
				Showroom showroom = new Showroom();
				showroom.setRoomID(data.getInt("room_id"));
				showroom.setRoomName(data.getString("room_name"));
				showroom.setTheaterName(data.getString("theater_name"));
				showroom.setSeats(getSeats(showroom.getRoomName()));
				showroom.setShowTimes(getShowTimes(showroom.getRoomName()));

				showRooms.add(showroom);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return showRooms;
	}

	public ArrayList<Seat> getSeats(String roomName){
		ArrayList<Seat> seats = new ArrayList<>();
		ResultSet data;

		try{
			String query = "SELECT * FROM SEAT WHERE room_id = (SELECT room_id FROM SHOW_ROOMS WHERE room_name = ?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, roomName);
			data = statement.executeQuery();
			while(data.next()){
				Seat seat = new Seat();
				seat.setAvailability(data.getInt("available"));
				seat.setRoomID(data.getInt("room_id"));
				seat.setTheatreID(data.getInt("theaterID"));
				seat.setSeatNumber(data.getString("seat_number"));

				seats.add(seat);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return seats;
	}

	public ArrayList<ShowTime> getShowTimes(String roomName){
		ArrayList<ShowTime> showtimes = new ArrayList<>();
		ResultSet data;

		try{
			String query = "SELECT * FROM SHOW_TIMES WHERE room_id = (SELECT room_id FROM SHOW_ROOMS WHERE room_name = ?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, roomName);
			data = statement.executeQuery();

			while(data.next()){
				ShowTime showtime = new ShowTime();
				showtime.setDateOfShow(data.getString("date_of_show"));
				showtime.setTimeOfShow(data.getString("time_of_show"));
				showtimes.add(showtime);
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return showtimes;
	}

	public boolean validateLogin(String email, String password){
		boolean isAuthenticated = false;
		ResultSet data;

		try{
			String query = "SELECT * FROM REGISTERED_USERS WHERE email = ? AND password = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			data = statement.executeQuery();

			if(data.next()){
				isAuthenticated = true;
			}
			
			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return isAuthenticated;
	}

	public Account getAccount(String email){
		Account account = new Account();
		ResultSet data;

		try{
			String query = "SELECT * FROM REGISTERED_USERS WHERE email = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, email);
			data = statement.executeQuery();

			if(data.next()){
				account.setEmail(data.getString("email"));
				account.setPassword(data.getString("password"));
				account.setAddress(data.getString("address"));
				account.setFname(data.getString("Fname"));
				account.setLname(data.getString("Lname"));
				account.setPayment(data.getString("payment_card"));
				account.setFeesPaid(data.getInt("fees_paid"));
				account.setDatePaid(data.getString("date_paid"));
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return account;
	}

	public void registerUser(Account account){

		try{
			String query = "INSERT INTO REGISTERED_USERS (Fname, Lname, address, payment_card, fees_paid, date_paid, email, password) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);

			statement.setString(1, account.getFname());
			statement.setString(2, account.getLname());
			statement.setString(3, account.getAddress());
			statement.setString(4, account.getPayment());
			statement.setInt(5, 0);
			statement.setString(6, null);
			statement.setString(7, account.getEmail());
			statement.setString(8, account.getPassword());

			statement.executeUpdate();

			statement.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void updateFeesStatus(String email){
		
		try{
			String query = "UPDATE REGISTERED_USERS SET fees_paid = 1, date_paid = ? WHERE email = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, java.time.LocalDate.now().toString());
			statement.setString(2, email);
			statement.executeUpdate();
			statement.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public boolean validateTicket(int ticketID){
		boolean isValidated = false;
		ResultSet data;

		try{
			String query = "SELECT * FROM TICKET WHERE ticketID = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, ticketID);
			data = statement.executeQuery();

			if(data.next()){
				isValidated = true;
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return isValidated;
	}

	public Ticket getTicket(int ticketID){
		Ticket ticket = new Ticket();
		ResultSet data;

		try{
			String query = "SELECT * FROM TICKET WHERE ticketID = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, ticketID);
			data = statement.executeQuery();

			while(data.next()){
				ticket.setTicketID(data.getInt("ticketID"));
				ticket.setDOP(data.getString("date_of_purchase"));
				ticket.setDOS(data.getString("date_of_show"));
				ticket.setforRegisteredUser(data.getInt("for_registered_user"));
				ticket.setseatID(data.getInt("seatID"));
			}

			data.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return ticket;
	}

	public void removeTicket(int ticketID){

		try{
			String query = "DELETE FROM TICKET WHERE ticketID = ?";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, ticketID);
			statement.executeQuery();

		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
