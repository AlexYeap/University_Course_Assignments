package edu.ucalgary.ensf409;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Movement implements FormattedOutput ,Cloneable{
    private String action;
    private String direction;
    private String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
    private Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException{
        Matcher regexMatcher = PATTERN.matcher(movement);
        if(regexMatcher.find()){
    
            this.action = regexMatcher.group(1);
            System.out.println(regexMatcher.group(2));
            this.direction = regexMatcher.group(2);
        }
        else{
            throw new IllegalArgumentException();
        }
        try{
            Actions.valueOf(this.action);
            Directions.valueOf(this.direction);
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
 

        
     
        
    

        
        
    
  
    }
    public String getAction(){
        return this.action;
    }
    public String getDirection(){
        return this.direction;
    }
    public Object clone() throws CloneNotSupportedException{
        Movement copy = (Movement)super.clone();
        return copy;
        
    }
    
    public String getFormatted() {
        
       String format = "Action: " + Actions.valueOf(this.action) + "," + " Direction: " + Directions.valueOf(this.direction);
        return format;
    }

}
