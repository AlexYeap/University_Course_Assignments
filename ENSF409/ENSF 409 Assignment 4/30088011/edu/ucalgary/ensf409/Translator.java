package edu.ucalgary.ensf409;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Translator {
    private TranslationText Translation;
    private String Code;
    private String REGEX = "^[a-z]{2}-{1}[A-Z]{2}$";
    private Pattern PATTERN = Pattern.compile(REGEX);    
    
    /* getTranslation()
    * getter method returning a stored TranslationText object.
    */

    
    public TranslationText getTranslation(){
        return Translation;
    }

    /* translate()
    * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
    * the 31st), and a year. Note that years may be any previous year in the common era 
    * (CE) from 0 to the previous year, or they may be before the common era (BCE),
    * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
    * Method throws an IllegalArgumentException if monthNum or dayNum is not
    * valid. Returns the formatted sentence as a String. Notice that the String
    * containing formatting uses numbered arguments - this is because some languages
    * will put the words in the sentence in a different order, but the translate()
    * method must be able to work without knowledge of the language structure.
    * Note: You do not have to check if a day is valid for a particular month/year;
    * February 31 or February 29, 2021 can both be accepted, but out of range values
    * e.g., month 15 day 0, are not valid and should be handled with an 
    * IllegalArgumentException. 
    */

    public String translate(int month, int day, int year){
        String Day, Month;
        if (month > 0 && month <= 12 && day > 0 && day < 31){
            Month = this.Translation.getMonth(month - 1);
            Day = this.Translation.getDay(day - 1);
        }
        else{
            throw new IllegalArgumentException();
        }
        String Sentence = this.Translation.getSentence();

        return Sentence.replace("%1$s", Day).replace("%2$s", Month).replace("%3$d", Integer.toString(year));
        }

    /* Constructor
    * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
    * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
    * and region code are not in the correct format. Language codes are ISO 639-1 and
    * region codes are ISO 3166, but this method only checks the format of the String, 
    * not if the region and language codes are valid according to the ISO specifications.
    * It calls importTranslation().
    */

    public Translator(String code) throws IllegalArgumentException, ArgFileNotFoundException, IOException{
        Matcher MATCHER = PATTERN.matcher(code);
        if (!MATCHER.matches()){
            throw new IllegalArgumentException();
        } 
        else{
            this.Code = code;
            importTranslation();
        }
    }

    /* importTranslation()
    * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
    * No arguments. Returns void.
    */

    public void importTranslation() throws ArgFileNotFoundException, IOException{
       
        try{
            FileInputStream file = new FileInputStream(this.Code + ".ser");
            deserialize();
        }
        catch (FileNotFoundException e){
            importFromText();
        }

    }

    /* importFromText()
    * Reads in from a the two-letter language code, dash, two-letter region code text 
    * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
    * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
    * when the file isn't found. 
    * We expect the .txt file to be in a valid format. The file is expected to be in the same 
    * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
    * always consist of the month names, one per line, followed by the day names, one per line, 
    * followed by the sentence containing formatting strings. This is the last line in the file. You
    * cannot make any assumptions about what will appear on each line, only that each line
    * will contain only one data element, and that it will not contain an empty line.
    * No arguments. Returns void.
    */

    public void importFromText() throws ArgFileNotFoundException, IOException{
    FileInputStream br = null;
    try{
        br = new FileInputStream(this.Code + ".txt");
    }
    catch (FileNotFoundException e){
        throw new ArgFileNotFoundException();
    }

    Scanner sc = new Scanner(br);
    int counter = 0;
    List<String> monthsList = new ArrayList<String>();
    List<String> daysList = new ArrayList<String>();
    String sentence = null;

    while(sc.hasNextLine()){
        String line = sc.nextLine();
        if(counter < 12){
            monthsList.add(line);
        }

        if (counter >= 12 && counter <= 42){
            daysList.add(line);
        }

        if(counter == 43){
            sentence = line;
            
        }

        counter++;
    }

    String[] months = monthsList.toArray(new String[12]);
    String[] days = daysList.toArray(new String[31]);

    this.Translation = new TranslationText(months, days, sentence);
    sc.close();
    serialize();

    /*for (String s : months) {
    System.out.println(s);
    }
    for (String s : days) {
    System.out.println(s);
    }*/
    


    }

    /* serialize()
    * Creates a serialized object file of the TranslationText object, with the
    * name format la-CO.ser, where la is the two-letter language code and CO is
    * the two-letter region code. An example of a serialized object file can be
    * found in the exercise directory as es-BO.ser
    * I/O exceptions can be thrown.
    * No arguments. Returns void.
    */

    public void serialize() throws IOException{
        ObjectOutputStream output = null;
        try{
            FileOutputStream file = new FileOutputStream(this.Code + ".ser");
            output = new ObjectOutputStream(file);
            output.writeObject(this.Translation);
            output.close();
            file.close();

        }
        catch(IOException e){
            throw new IOException();
        }

    }


    /* deserialize()
    * Creates a TranslationText object from a .ser file. The files are named
    * xx-YY.ser, where xx is the two-letter language code and YY is the two-
    * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
    * No arguments. Returns void.
    */

    public void deserialize() throws ArgFileNotFoundException, IOException{
        ObjectInputStream input = null;

        try{
            FileInputStream file = new FileInputStream(this.Code + ".ser");
            input = new ObjectInputStream(file);
            this.Translation = (TranslationText) input.readObject();
            input.close();
            file.close();

        }
        catch(FileNotFoundException e){
            throw new ArgFileNotFoundException();
        }
        catch(Exception e){
            throw new IOException();
        }

    }
}

    
