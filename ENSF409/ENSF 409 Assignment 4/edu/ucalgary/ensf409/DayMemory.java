

import java.io.IOException;

public class DayMemory {
  public static void main(String[] args) throws ArgFileNotFoundException, CommandArgumentNotProvidedException, IllegalArgumentException, IOException{
    try{
      String translationFile = "es-BO";

      Translator trans = new Translator();
      trans.Translator(translationFile);
      System.out.println(trans.translate(3,8,2001));
      trans.serialize();

        /*Translator code = new Translator();
    code.Translator(translationFile);
    code.importTranslation();
    System.out.println(code.translate(3,8,-200));
    code.serialize();
    */
    
    }
    catch(ArrayIndexOutOfBoundsException e){
      throw new CommandArgumentNotProvidedException();
    }
  }
}
  /* main()
   * Accept a command-line argument which specifies a translation file.
   * The argument should be in the form of a two-letter language code,
   * followed by a dash and a two-letter region code, e.g., en-US
   * which corresponds with files en-US.txt and en-US.ser
   * If no argument is specified, it throws a custom exception,
   * CommandArgumentNotProvidedException, which extends Exception. 
   * Additional arguments are ignored.
  */