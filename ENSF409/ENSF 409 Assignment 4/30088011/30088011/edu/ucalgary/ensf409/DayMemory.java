package edu.ucalgary.ensf409;

import java.io.IOException;

public class DayMemory {
  /* main()
  * Accept a command-line argument which specifies a translation file.
  * The argument should be in the form of a two-letter language code,
  * followed by a dash and a two-letter region code, e.g., en-US
  * which corresponds with files en-US.txt and en-US.ser
  * If no argument is specified, it throws a custom exception,
  * CommandArgumentNotProvidedException, which extends Exception. 
  * Additional arguments are ignored.
*/



  public static void main(String[] args) throws IllegalArgumentException, ArgFileNotFoundException, IOException, CommandArgumentNotProvidedException{
    try{
      String translationFile = args[0];
      Translator trans = new Translator(translationFile);
      System.out.println(trans.translate(3,8,2021));
    }
    catch(ArrayIndexOutOfBoundsException e){
      throw new CommandArgumentNotProvidedException();
    }
  }
}
      
