package edu.ucalgary.ensf409;
import java.io.Serializable;

public class TranslationText implements Serializable{
    static final long serialVersionUID = 19L;
    private String Sentence;
    private String[] Months;
    private String[] Days;
 


    public TranslationText(String sentence, String[] months, String[] days){
        this.Months = months;
        this.Days = days;
        this.Sentence = sentence;
    }

    public String getSentence(){
        return this.Sentence;
    }
    
    public String[] getMonths(){
        return this.Months;
    }

    public String[] getDays(){
        return this.Days;
    }
    public String getMonth(int numberOfMonth){
        return this.Months[numberOfMonth];

    }
    public String getDay(int numberOfDay){
        return this.Days[numberOfDay];
    }







}
/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19.
*/

  /* getSentence()
   * Getter method, returns String
  */

  /* getMonths()
   * Getter method, returns String[]
  */

  /* getDays()
   * Getter method, returns String[]
  */

  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */

  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */
