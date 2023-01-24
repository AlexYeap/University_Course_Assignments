public class Ticket {
    private int ticketID = 0;
    private int forRegisteredUser = 0;
    private int userID = 0;
    private int seatID = 0;
    private String dop = "";
    private String dos = "";

    public Ticket()
    {
        
    }

    public void setTicketID(int s) {
        ticketID = s;
    }

    public void setforRegisteredUser(int s) {
        forRegisteredUser = s;
    }

    public void setUserID(int s) {
        userID = s;
    }

    public void setseatID(int s) {
        seatID = s;
    }

    public void setDOP(String s) {
        dop = s;
    }

    public void setDOS(String s) {
        dos = s;
    }

    public int getTicketID()
    {
        return ticketID;
    } 

    public int getforRegisteredUser()
    {
        return forRegisteredUser;
    }

    public int getUserID()
    {
        return userID;
    }

    public int getseatID()
    {
        return seatID;
    }

    public String getDOP()
    {
        return dop;
    }

    public String getDOS() 
    {
        return dos;
    }
}
