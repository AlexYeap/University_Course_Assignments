public class Account {

    private int userID;
    private String email;
    private String password = "";
    private String address;
    private String Fname;
    private String Lname;
    private String paymentCard;
    private int feesPaid = 0;
    private String datePaid = "";

    public Account(){

    }

    public Account(int userID, String email, String password, String address, String Fname, String Lname, String paymentCard, int feesPaid, String datePaid){
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.address = address;
        this.Fname = Fname;
        this.Lname = Lname;
        this.paymentCard = paymentCard;
        this.feesPaid = feesPaid;
        this.datePaid = datePaid;
    }


    public void setUserID(int userid){
        this.userID = userid;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPassword(char[] password){
        this.password = "";
        for(int i = 0; i < password.length; i++){
            this.password += password[i];
        }
    }

    public void setFname(String Fname){
        this.Fname = Fname;
    }

    public void setLname(String Lname){
        this.Lname = Lname;
    }

    public void setPayment(String card){
        this.paymentCard = card;
    }

    public void setFeesPaid(int feesPaid){
        this.feesPaid = feesPaid;
    }

    public void setDatePaid(String datePaid){
        this.datePaid = datePaid;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getUserID(){
        return userID;
    }

    public String getFname(){
        return Fname;
    } 

    public String getLname(){
        return Lname;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getDatePaid(){
        return datePaid;
    }

    public String getPayment(){
        return paymentCard;
    }

    public int getFeesPaid(){
        return feesPaid;
    }
}
