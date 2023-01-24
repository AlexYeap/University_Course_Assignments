/*  
* File Name: rectangle.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
*/
#include <iostream>
using namespace std;
#include "square.h"
#include "shape.h"

#ifndef RECTANGLE_H
#define RECTANGLE_H
class Rectangle : public Square{
    
    private:
    double side_b;

    public:
    Rectangle (double x, double y, double z, double s, const char* name);

    double area();
    double perimeter();
    void display();
    double get_side_b();
    char* getName()const {return Shape::getName();};
    void set_side_b(double side);



};
#endif