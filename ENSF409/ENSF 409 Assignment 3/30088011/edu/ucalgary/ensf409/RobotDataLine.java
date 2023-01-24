package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotDataLine implements Cloneable {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    private String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private Pattern DATE_PATTER = Pattern.compile(DATE_REGEX);
    private String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line) throws IllegalArgumentException{
        this.dataLine = line;
        Matcher IDMatcher = ROBOT_PATTERN.matcher(line);
        if (IDMatcher.find()){
            this.robotID = IDMatcher.group().trim();
        }
        else{
            throw new IllegalArgumentException();
        }

        this.sensor = new Sensor(line);;
        this.movement = new Movement(line);
        Matcher dateMatcher = DATE_PATTER.matcher(line);
        if (dateMatcher.find()){
            int day = Integer.parseInt(dateMatcher.group(1));
            int month = Integer.parseInt(dateMatcher.group(2));
            int year = Integer.parseInt(dateMatcher.group(3));
            this.date = LocalDate.of(year,month,day);
        } 
        else{
            throw new IllegalArgumentException();
        } 
        
    }
    public String getRobotID(){
        return robotID;
    }
    public String getDataLine(){
        return dataLine;
    }
    public Sensor getSensor(){
        return sensor;
    }
    public Movement getMovement(){
        return movement;
    }
    public LocalDate getDate() {
        return date;
    }
    public Object clone() throws CloneNotSupportedException{
        RobotDataLine copy = (RobotDataLine)super.clone();
        copy.sensor = (Sensor)sensor.clone();
        return copy;
        
    }

}
