/*  
* File Name: square.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
*/
#include <iostream>
using namespace std;
#include "shape.h"
#include "point.h"
#ifndef SQUARE_H
#define SQUARE_H
class Square: virtual public Shape{
    private:
    double side_a;

    public:
    Square(double x, double y, double z, const char* name);
    double get_side_a()const;
    void set_side_a(double side);
    char* getName()const {return Shape::getName();};
    double area();
    double perimeter();
    void display();
    

};
#endif