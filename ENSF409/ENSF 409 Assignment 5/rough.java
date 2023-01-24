package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class VisitorParking {
    private List<String> licensePlate = new ArrayList<String>(3);
    private List<LocalDate> date = new ArrayList<LocalDate>(3);
    private int numberOfRes;
    private int numberOfResDate;
    HashMap<String, String> plates = new HashMap<String, String>();
    
    private String regex = "^[A-Za-z0-9 _ -]+";
    private Pattern pattern = Pattern.compile(regex);
    public VisitorParking() {
    }

    public VisitorParking(String licence){
        Matcher matcher = pattern.matcher(licence);

        if(plates.get(licence) != ""){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfRes++;
                plates.put(licence, "");
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public VisitorParking(String licence, LocalDate aDate) {
        Matcher matcher = pattern.matcher(licence);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if(!plates.containsKey(licence) && !plates.containsValue(aDate.toString())){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else{
            throw new IllegalArgumentException();
        }
    }


    public void addVisitorReservation(String licence) {
        Matcher matcher = pattern.matcher(licence);
        if (numberOfRes == 2){
                throw new IllegalArgumentException();

        }
        else if(plates.get(licence) != ""){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfRes++;
                plates.put(licence, "");
                
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void addVisitorReservation(String licence, LocalDate aDate) {
        Matcher matcher = pattern.matcher(licence);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if (numberOfResDate == 2 && !plates.containsKey(licence)) {
            if(Math.abs(date.get(0).getDayOfMonth() - aDate.getDayOfMonth()) <= 2){
                throw new IllegalArgumentException();
            }

        }
        else if (numberOfResDate >= 1 && plates.containsKey(licence) && plates.get(licence) != "") {
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(licence);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            plates.put(licence, aDate.toString());
                        }
                        else{
                            throw new IllegalArgumentException();
                        }
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        
        }
        else if( plates.containsKey(licence) && plates.get(licence) == ""){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else if (numberOfResDate == 1 && plates.containsKey(licence) && plates.get(licence) != ""){
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(licence);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            plates.put(licence, aDate.toString());
                        }
                        else{
                            throw new IllegalArgumentException();
                        }
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        
        }
        else if( plates.containsKey(licence) && plates.get(licence) == ""){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(plates.containsKey(licence) && Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
             if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(!plates.containsKey(licence) && !plates.containsValue(aDate.toString())){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence, aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence, aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        
        else{
            throw new IllegalArgumentException();
        }
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        Set<String> keys = plates.keySet();

        // iterate through the key set and display key and values
        for (String key : keys) {
            if(plates.get(key) == date.toString()){
                return true;

            }
       
        }
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return true;
    }



}












package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class VisitorParking {
    private List<String> licensePlate = new ArrayList<String>(3);
    private List<LocalDate> date = new ArrayList<LocalDate>(3);
    private int numberOfRes;
    private int numberOfResDate;
    HashMap<String,List <String>> plates = new HashMap<String, List <String>>();
    
    private String regex = "^[A-Za-z0-9 _ -]+";
    private Pattern pattern = Pattern.compile(regex);
    public VisitorParking() {
    }

    public VisitorParking(String licence){
        Matcher matcher = pattern.matcher(licence);

        if(!plates.get(licence).contains("N")){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfRes++;
                plates.put(licence,new ArrayList<>()).add("N");
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public VisitorParking(String licence, LocalDate aDate) {
        Matcher matcher = pattern.matcher(licence);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if(!plates.containsKey(licence) && !plates.get(licence).contains(aDate.toString())){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence,new ArrayList<>()).add(aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence,new ArrayList<>()).add(aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence,new ArrayList<>()).add(aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else{
            throw new IllegalArgumentException();
        }
      
    }


    public void addVisitorReservation(String licence) {
        Matcher matcher = pattern.matcher(licence);
        if (numberOfRes == 2){
                throw new IllegalArgumentException();

        }
        else if(!plates.get(licence).contains("N")){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfRes++;
                plates.put(licence,new ArrayList<>()).add("N");
                
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void addVisitorReservation(String licence, LocalDate aDate) {
        Matcher matcher = pattern.matcher(licence);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if (numberOfResDate == 2 && !plates.containsKey(licence)) {
            if(Math.abs(date.get(0).getDayOfMonth() - aDate.getDayOfMonth()) <= 2){
                throw new IllegalArgumentException();
            }

        }
        else if (numberOfResDate >= 1 && plates.containsKey(licence) && !plates.get(licence).contains("N")) {
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(licence);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            plates.get(licence).add(aDate.toString());
                        }
                        else{
                            throw new IllegalArgumentException();
                        }
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        
        }
        else if(plates.containsKey(licence) && plates.get(licence).contains("N")){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else if (numberOfResDate == 1 && plates.containsKey(licence) && !plates.get(licence).contains("N")){
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(licence);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            plates.get(licence).add(aDate.toString());
                        }
                        else{
                            throw new IllegalArgumentException();
                        }
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        
        }
        else if( plates.containsKey(licence) && plates.get(licence).contains("N")){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(plates.containsKey(licence) && Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
             if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.get(licence).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.get(licence).add(aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(!plates.containsKey(licence) && !plates.get(licence).contains(aDate.toString())){
            if(licence.length() > 0 && licence.length() <= 7 && matcher.matches()){
                this.licensePlate.add(licence);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(licence,new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(licence,new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(licence,new ArrayList<>()).add(aDate.toString());
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        
        else{
            throw new IllegalArgumentException();
        }
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {

        // iterate through the key set and display key and values
        if(plates.get(licence).contains(date.toString())){
            return true;
        }
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return true;
    }



}
