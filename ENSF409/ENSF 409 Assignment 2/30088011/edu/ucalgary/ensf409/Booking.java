package edu.ucalgary.ensf409;

public class Booking {
    private String STARTDATE;
    private String ENDDATE;
    private Pet BOOKEDPET;
    private Employee CAREGIVER;
    
    public Booking(Pet pet, Employee assigned, String startDate, String endDate){
        this.BOOKEDPET = pet;
        this.CAREGIVER = assigned;
        this.STARTDATE = startDate;
        this.ENDDATE = endDate;
    }
    public String getStartDate() {
        return this.STARTDATE;
    }
    public String getEndDate() {
        return this.ENDDATE;
    }
    public Pet getBookedPet(){
        return this.BOOKEDPET;
    }
    public Employee getCaregiver(){
        return this.CAREGIVER;
    }
}
