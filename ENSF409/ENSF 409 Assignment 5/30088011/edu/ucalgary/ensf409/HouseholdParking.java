/*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;
import java.time.LocalDate;
import java.util.*;

public class HouseholdParking extends CalgaryProperty {
    // Each residental property is allowed one street parking permit
    private String residentLicence;
   
    private VisitorParking Visitors = new VisitorParking();
    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode,buildingAnnex);
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most recent
     * Ignore if the licence is already stored
     * @param licence - The licence plate to be added
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta licence
    */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        licence = Parking.standardizeAndValidateLicence(licence);
     

        // If licence is already in the list, don't continue
        if (licence == residentLicence){
            return; 
        }

        // If fewer than three are stored, add to list
        else{
            residentLicence = licence;
        }
           
 
        // If more than three are stored, replace last in list

    }
    /*
     * Remove all listed licences
     * @return whether the operation succeeded or not
    */
    public boolean removeResidentLicence() {
        this.residentLicence = "";
        return true;
    }

    /*
     * Remove a specific listed licence 
     * @param licence - the licence to be removed
     * @return whether the operation succeeded or not
    */


    /*
     * Get all the licences stored for the resident
     * @return An array containing the resident's licences
    */
    public String getResidentLicence() {
       String result = this.residentLicence;
       return result;
    }

    public VisitorParking getVisitors() {
        return this.Visitors;
    }

    public void addVisitorReservation(String license) {
        this.Visitors.addVisitorReservation(license);
    }

    public void addVisitorReservation(String license, LocalDate date) {
        this.Visitors.addVisitorReservation(license,date);
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate commonDate) {
        return this.Visitors.getLicencesRegisteredForDate(commonDate);
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return this.Visitors.getLicencesRegisteredForDate();
    }

    public boolean licenceIsRegisteredForDate(String license) {
        return this.Visitors.licenceIsRegisteredForDate(license);
    }

    public boolean licenceIsRegisteredForDate(String license, LocalDate date) {
        return this.Visitors.licenceIsRegisteredForDate(license, date);
    }

    public Object getAllDaysLicenceIsRegistered(String license) {
        return this.Visitors.getAllDaysLicenceIsRegistered(license);
    }

    public Object getStartDaysLicenceIsRegistered(String license) {
        return this.Visitors.getStartDaysLicenceIsRegistered(license);
    }

}
