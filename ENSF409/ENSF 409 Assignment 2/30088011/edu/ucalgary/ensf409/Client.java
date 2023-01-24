package edu.ucalgary.ensf409;


public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsinfo;

    public Client(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rewardsinfo = new RewardsProfile();

    }
    public boolean enrollRewards(String newNumber) throws InvalidRewardsNumException{

        try{
            this.rewardsinfo = new RewardsProfile(newNumber);
        }
        catch(InvalidRewardsNumException e){
            return false;
        }
        return true;
       

    }

    public int getRewardsPoints(){
        return this.rewardsinfo.getPoints();

    }
    public String getRewardsNumber(){
        return this.rewardsinfo.getNumber();
    }

    public String getName(){
        return this.name;

    }
    public void setName(String name){
        this.name = name;

    }
    public String getPhoneNumber(){

        return this.phoneNumber;
    }
    public void setPhoneNumber(String num){
        this.phoneNumber = num;

    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;

    }
    public int updatePoints(int addPoints){
        int Point =  this.rewardsinfo.getPoints();
        int totalPoints = Point + addPoints;
        this.rewardsinfo.setPoints(totalPoints);
        return totalPoints;
    
    }

    

}
