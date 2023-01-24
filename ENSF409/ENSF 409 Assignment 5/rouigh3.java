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
    private HashMap<String, String> plates = new HashMap<String, String>();
    private Map<String, List<String>> duplicatePlates = new HashMap<String, List<String>>();
    private Map<String, List<String>> duplicatePlates2 = new HashMap<String, List<String>>();
    private Map<String, List<String>> duplicatePlates3 = new HashMap<String, List<String>>();
   

    
    private String regex = "^[A-Za-z0-9 _ -]+";
    private Pattern pattern = Pattern.compile(regex);
    public VisitorParking() {
    }

    public VisitorParking(String license){
        Matcher matcher = pattern.matcher(license);
        LocalDate currentDate = LocalDate.now();
        if(plates.get(license) != ""){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfRes++;
                plates.put(license, "");
                duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(currentDate.toString());
                
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public VisitorParking(String license, LocalDate aDate) {
        Matcher matcher = pattern.matcher(license);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if(!plates.containsKey(license) && !plates.containsValue(aDate.toString())){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                }
                if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(license, aDate.toString());
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


    public void addVisitorReservation(String license) {
        Matcher matcher = pattern.matcher(license);
        LocalDate currentDate = LocalDate.now();
        if (numberOfRes == 2){
                throw new IllegalArgumentException();

        }
        else if(plates.get(license) != ""){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfRes++;
                plates.put(license, "");
                duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(currentDate.toString());
                
            }
            else{
                throw new IllegalArgumentException();
            }

        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void addVisitorReservation(String license, LocalDate aDate) {
        Matcher matcher = pattern.matcher(license);
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();

        if (numberOfResDate == 2 && !plates.containsKey(license)) {
            if(Math.abs(date.get(0).getDayOfMonth() - aDate.getDayOfMonth()) <= 2){
                throw new IllegalArgumentException();
            }

        }
        else if (numberOfResDate >= 1 && plates.containsKey(license) && plates.get(license) != "") {
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(license);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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
        else if(plates.containsKey(license) && plates.get(license) == ""){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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
        else if (numberOfResDate == 1 && plates.containsKey(license) && plates.get(license) != ""){
            if(Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
                if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                    this.licensePlate.add(license);
                    numberOfResDate++;
                    if(aDate.getYear() > year){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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
        else if(plates.containsKey(license) && plates.get(license) == ""){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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
        else if(plates.containsKey(license) && Math.abs(date.get(date.size()-1).getDayOfMonth() - aDate.getDayOfMonth()) > 2){
             if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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
        else if(!plates.containsKey(license) && !plates.containsValue(aDate.toString())){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(license, aDate.toString());
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.toString());
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

    public boolean licenceIsRegisteredForDate(String license, LocalDate date) {
        Set<String> keys = plates.keySet();

        // iterate through the key set and display key and values
        for(String key : keys) {
            if(plates.get(key) == date.toString()){
                return true;
            }
       
        }
        /*
        Set<String> setOfKeySet = duplicatePlates.keySet();
        for(String key : setOfKeySet) {
            System.out.println("License : "  + key);
            for(String aDate : duplicatePlates.get(key)) {
                System.out.println("date : "  + aDate);
                if(key == license && aDate == date.toString()){
                    return true;
                }
            }
        }
        */
        int i = 0;
        while(i < 100){
            if(duplicatePlates.get(license).get(i).contains(date.toString())){
                return true;
            }
        
            i++;
        }
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        Set<String> keys = plates.keySet();
        for(String key : keys) {
            if(plates.get(key) == ""){
                return true;
            }
       
        }
        return false;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
        ArrayList<LocalDate> list = new ArrayList<LocalDate>();
        Set<String> setOfKeySet = duplicatePlates.keySet();
        for(String key : setOfKeySet) {
            System.out.println("License : "  + key);
            for(String aDate : duplicatePlates.get(key)) {
                System.out.println("date : "  + aDate);

                }
            }
        }
    }

}

