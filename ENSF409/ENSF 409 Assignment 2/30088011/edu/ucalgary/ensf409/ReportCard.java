package edu.ucalgary.ensf409;

public class ReportCard {
    private Booking REPORT;

    public ReportCard(Booking reportinfo){
        this.REPORT = reportinfo;
    }
    public String printReport(){
        StringBuilder Format = new StringBuilder();
        Format.append(this.REPORT.getCaregiver().getName() + " enjoyed taking care of " + this.REPORT.getBookedPet().getName() + ". See you next time!");
        return Format.toString();

    }
}
