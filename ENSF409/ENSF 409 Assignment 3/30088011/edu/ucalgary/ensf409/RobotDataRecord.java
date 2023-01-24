package edu.ucalgary.ensf409;

import java.util.ArrayList;


public class RobotDataRecord implements Cloneable{
    private ArrayList<RobotDataLine> log = new ArrayList<>();

    public RobotDataRecord(String[] array){
        for (int i = 0; i < array.length; i++){
            log.add(new RobotDataLine(array[i]));
        }

    }
    public RobotDataLine getLine(int index){
        return log.get(index);

    }
    public ArrayList<RobotDataLine> getDataRecord(){
        return log;
    }
    
    public Object clone() throws CloneNotSupportedException{
        RobotDataRecord copy = (RobotDataRecord)super.clone();
        copy.log = (ArrayList<RobotDataLine>)log.clone();
        return copy;
        
    }
}
