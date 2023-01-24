public class User {
    private String email;
    private String address;
    private String Fname;
    private String Lname;

    public User(){

    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFname(String Fname){
        this.Fname = Fname;
    }

    public void setLname(String Lname){
        this.Lname = Lname;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void payFee(Payment payment){
        
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
}
