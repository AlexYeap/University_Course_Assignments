package edu.ucalgary.ensf409;

public class Employee {

    private String name;
    private String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployee = new Employee[10];

    public Employee(String name, String idNumber){
        this.name = name;
        this.IDNUMBER = idNumber;

    }
    public Employee(String name, String idNumber, String managerID){
        this.name = name;
        this.IDNUMBER = idNumber;
        this.managerID = managerID;

    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getIDNumber(){
        return this.IDNUMBER;

    }
    public String getManagerID(){
        return this.managerID;
    }
    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }
    public void addEmployee(Employee newEmployee){
        for(int i = 0 ; i < supervisedEmployee.length; i++){
            if (supervisedEmployee[i] == null){
                supervisedEmployee[i] = newEmployee;
                break;
            }
        }

    }
    public Employee[] getEmployees(){
        return this.supervisedEmployee;

    }


}
