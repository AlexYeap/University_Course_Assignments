package edu.ucalgary.ensf409;

public class RewardsProfile {
    private String rewardsNum = "Not enrolled";
    private int pointsTotal = 10;

    public RewardsProfile(){


    }

    public RewardsProfile(String newNumber)throws InvalidRewardsNumException{
        if(newNumber.length() > 7){
            throw new InvalidRewardsNumException();
        }
        String regex = "[0-9]+";
        boolean result = newNumber.matches(regex);
        if (result == true){
             this.rewardsNum = newNumber;
        }
        if (result == false){
          throw new InvalidRewardsNumException();
        }
   

     }
    public void setPoints(int addPoints){
        this.pointsTotal = addPoints;
    }
    public int getPoints(){
        return this.pointsTotal;
    
    }
    public String getNumber(){
        return this.rewardsNum;
    }
}
