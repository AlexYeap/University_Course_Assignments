package edu.ucalgary.ensf409;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements FormattedOutput, Cloneable{
    private String sensor;
    private String REGEX = "\\(([a-z]+)\\)";
    private Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException{
        Matcher RegexMatcher = PATTERN.matcher(sensor);
        if (RegexMatcher.find()){
            this.sensor = RegexMatcher.group(1);
        }
        else{
            throw new IllegalArgumentException();
        }
        
    }
    public String getSensor(){
        return sensor;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    public String getFormatted() {
        return "Sensor: " + this.sensor;
    }
}
