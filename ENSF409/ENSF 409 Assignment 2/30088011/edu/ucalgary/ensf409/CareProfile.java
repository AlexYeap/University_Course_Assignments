package edu.ucalgary.ensf409;

public class CareProfile{
    private String[] medList;
    private String medInstructions;
    private String feedingInstructions;

    public CareProfile(String[] medList, String meds, String feeding){
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }
    public String summmarizeCareInstructions(){
        StringBuilder Format = new StringBuilder();
        for(int i = 0; i < this.medList.length; i++){
            Format.append(this.medList[i]);
            Format.append(", ");
        }
        Format.setLength(Format.length() - 2);

        
        String Summary = Format.toString() + System.lineSeparator() + this.medInstructions + System.lineSeparator() + this.feedingInstructions;
        return Summary;

    }
    
}
