/*  
* File Name: circle.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
*/
#include <iostream>
using namespace std;
#include "shape.h"
#include "point.h"

#ifndef CIRCLE_H
#define CIRCLE_H
class Circle: virtual public Shape{
    private:
    double radius;

    public:
    Circle(double x, double y, double z, const char* name);
    double area();
    double perimeter();
    double getr()const;
    char* getName()const {return Shape::getName();};
    void setr(double radi);
    void display();





};
#endif