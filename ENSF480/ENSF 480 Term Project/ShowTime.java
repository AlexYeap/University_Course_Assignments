public class ShowTime {
    private String dateOfShow;
    private String[] timeOfShow;
    
    public ShowTime(){

    }

    public String getDateOfShow(){
        return dateOfShow;
    }

    public String[] getTimeOfShow(){
        return timeOfShow;
    }

    public void setDateOfShow(String date){
        this.dateOfShow = date;
    }

    public void setTimeOfShow(String time){
        String[] times = time.split("-");
        this.timeOfShow = times;
    }
}
