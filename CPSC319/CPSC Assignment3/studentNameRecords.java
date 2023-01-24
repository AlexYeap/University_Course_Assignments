import java.util.ArrayList;
import java.util.Arrays;

public class studentNameRecords {
    private ArrayList<String> studentRecords = new ArrayList<String>();


    public studentNameRecords(){

    }

    public String studentRecords(String line){

        String name = line.substring(8,17).trim();
        String Lastname = "Last Name: " + line.substring(8,17).trim() + System.lineSeparator();
        String id = "ID: " + line.substring(1, 7) + System.lineSeparator();
        String homeDepartment = "Home Department: " + line.substring(33, 36) +  System.lineSeparator();
        String Program = "Program" + line.substring(37, 39) +  System.lineSeparator();
        String Year = "Year: " + line.substring(line.length()-1, line.length()) +  System.lineSeparator();

        studentRecords.add(Lastname);
        studentRecords.add(id);
        studentRecords.add(homeDepartment);
        studentRecords.add(Program);
        studentRecords.add(Year);
        studentRecords.add(System.lineSeparator());
        return name;
    }

    public void printArrayList(){
        for(int i = 0; i < 1; i++) {   
            System.out.print(Arrays.toString(studentRecords.toArray())+ " ");
        } 
    }





}
