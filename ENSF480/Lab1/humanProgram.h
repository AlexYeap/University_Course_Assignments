#ifndef HUMANPROGRAM_H
#define HUMANPROGRAM_H
#include <iostream>
using namespace std;

class Human{
private:
    Point location; // Location of an object of Human on a Cartisian Plain
    char *name;       // Human's name
public:
    Human(const char* nam="", double x=0, double y=0);
    char* get_name(); 
    void set_name(char* name);
    Point get_point()const;
    virtual void display();
};


class Point{
    friend class Human;
private:
    double x;     // x coordinate of a location on Cartisian Plain
    double y;     // y coordinate of a location on Cartisian Plain

public:
    Point(double a =0, double b =0);
    double get_x() const;                         
    double get_y() const;                       
    void set_x(double a);
    void set_y(double a);
};

#endif