/*
* File Name: ExerciseC.h
* Assignment: Lab 1 Exercise C
* Completed by: Alex Yeap and Bill Thai
* Submission Date: Sept 20, 2022
*/
#include <string>
#include <vector>
using namespace std;

struct Person{
    private:
    string name;
    string address;
    int phoneNumber;
    string dateOfBirth;
    string currentState;

    public:
    Person();
    Person(const string name, const string address, const string dateOfBirth);
    Person(const string name, const string address, const string phone);

    string getName() const;
    string getAddress() const;
    int getphoneNumber() const;
    string getDateOfBirth() const;
    string getCurrentState() const;

    void setName(string name);
    void setAddress(string address);
    void setPhoneNumber( int phoneNumber);
    void setDateOfBirth(string date);
    void setCurrentState(string state);

};
struct Company{
    private:
    string companyName;
    string companyAddress;
    string dateEstablished; // the date that company was established

    vector<Person> employees; // vector of information about employees’ information 
     // (name, address, date of birth)
    vector<Person> employeeState; // information about employees' current states 
    //(active, suspended, retired, fired)
    vector<Person> customers; // vector of information about customers
    // (name, address, phone)
    public:
    Company();
    Company(string companyName, string companyAddress);
    Company(string companyName, string companyAddress, string dateEstablished);
    string getCompanyName();
    string getCompanyAddress();
    string getDateEstablished();
    void setCompany(string name);
    void setCompanyAddress(string address);
    void setdateEstablished(string date);
}; 