package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class VisitorParking {
    private List<String> licensePlate = new ArrayList<String>(3);
    private List<LocalDate> date = new ArrayList<LocalDate>();
    private int numberOfRes;
    private int numberOfResDate;
    private HashMap<String, String> plates = new HashMap<String, String>();
    private Map<String, List<LocalDate>> duplicatePlates = new HashMap<String, List<LocalDate>>();
    private List <String> commonDateAddress = new ArrayList<>();

     // matches at least 2 whitespaces

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
                duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(currentDate);
                
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

        int space = 0;
        for(int i=0; i<=license.length()-1; i++){
            char ch = license.charAt(i);
            if(ch == ' '){
                space++;
            }
        }
        if(space > 2){
            license = license.replaceAll(" ", "").trim();
        }
        System.out.println(license);

        if(!plates.containsKey(license) && !plates.containsValue(aDate.toString())){
            if(license.length() > 0 && license.length() <= 7 && matcher.matches()){
                this.licensePlate.add(license);
                numberOfResDate++;
                if(aDate.getYear() > year){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(license, aDate.toString());
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
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
                duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(currentDate);
                
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
                        plates.put(license, aDate.toString());
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));

                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        plates.put(license, aDate.toString());
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
 
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            plates.put(license, aDate.toString());
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));

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
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
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
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    }
                    else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                        if (aDate.getDayOfMonth() >= day){
                            this.date.add(aDate);
                            duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
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
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
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
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
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
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() > month){
                    this.date.add(aDate);
                    plates.put(license, aDate.toString());
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                    duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
                }
                else if(aDate.getYear() == year && aDate.getMonthValue() == month){
                    if (aDate.getDayOfMonth() >= day){
                        this.date.add(aDate);
                        plates.put(license, aDate.toString());
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate);
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(1));
                        duplicatePlates.computeIfAbsent(license, k -> new ArrayList<>()).add(aDate.plusDays(2));
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
            if(duplicatePlates.get(license).contains(date)){
                return true;
            }
            if(duplicatePlates.get(license).contains(date.minusDays(1))){
                return true;
            }
            if(duplicatePlates.get(license).contains(date.minusDays(2))){
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
        ArrayList <LocalDate> dateList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        Set<String> setOfKeySet = duplicatePlates.keySet();
        int i = 1;
        for(String key : setOfKeySet) {
            for(LocalDate aDate : duplicatePlates.get(key)) {
                if(key == licence){             
                    if(i == 1 || i == 4 || i == 7 || i == 10 || i == 13 || i == 16 || i == 19 || i == 22 ||i == 25 || i == 28|| i == 31 || i == 34){
                        if(aDate.getDayOfMonth() == today.getDayOfMonth() && aDate.getMonthValue()== today.getMonthValue() && aDate.getYear() == today.getYear()){
                            System.out.println("Added" + aDate);;
                            dateList.add(aDate);
                            i--;
                        } 
                        else{
                        System.out.println("Added" + aDate);;
                        dateList.add(aDate);
                        }
                    }
                }  
                i++;
            }
        }
        Collections.sort(dateList);
        return dateList;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        ArrayList<String> listLicense = new ArrayList<>();
        Set<String> setOfKeySet = duplicatePlates.keySet();
        for(String key : setOfKeySet) {
            System.out.println("License : "  + key);
            if(!commonDateAddress.contains(key)){
                listLicense.add(Parking.standardizeAndValidateLicence(key));
                System.out.println("LicenseAdded : "  + Parking.standardizeAndValidateLicence(key));
            }
        }
        return listLicense;
    }
    public ArrayList<String> getLicencesRegisteredForDate(LocalDate commonDate) {
        ArrayList<String> listLicense = new ArrayList<>();
        Set<String> setOfKeySet = duplicatePlates.keySet();
        for(String key : setOfKeySet) {
            System.out.println("License : "  + Parking.standardizeAndValidateLicence(key));
            for(LocalDate aDate : duplicatePlates.get(key)) {
                if(aDate.getDayOfMonth() == commonDate.getDayOfMonth()){
                   if(!listLicense.contains(Parking.standardizeAndValidateLicence(key))){
                        System.out.println("Added: "  + Parking.standardizeAndValidateLicence(key));
                        listLicense.add(Parking.standardizeAndValidateLicence(key));
                        commonDateAddress.add(Parking.standardizeAndValidateLicence(key));
                   }
                   
                }
            }
        }
        return listLicense;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String license) {
        ArrayList <LocalDate> dateList = new ArrayList<>();
        Set<String> setOfKeySet = duplicatePlates.keySet();
        for(String key : setOfKeySet) {
            for(LocalDate aDate : duplicatePlates.get(key)) {
                if(key == license){
                    dateList.add(aDate);
                }
            }
        }
        Collections.sort(dateList);
        return dateList;
    }

}








