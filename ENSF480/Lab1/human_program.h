/*
* File Name: human_program.H
* Assignment: Lab 1 Exercise D
* Completed by: Alex Yeap and Bill Thai
* Submission Date: Sept 20, 2022
*/
#ifndef HUMAN_PROGRAM_H
#define HUMAN_PROGRAM_H
#include <cstring>
#include <iostream>
using namespace std;

class Point{
private:
    double x;     // x coordinate of a location on Cartisian Plain
    double y;     // y coordinate of a location on Cartisian Plain
    
public:
    Point(double a, double b);
    double get_x() const;                         
    double get_y() const;                       
    void set_x(double a);
    void set_y(double a);
};

class Human{
protected: // Location of an object of Human on a Cartisian Plain
    char *name;       // Human's name
    Point location;
public:
    Human(const char* nam, double x, double y);
    char* get_name(); 
    void set_name(char* name);
    Point get_point()const;
    void display();
};



#endif