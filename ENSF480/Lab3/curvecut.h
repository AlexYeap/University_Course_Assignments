/*  
* File Name: curvecut.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
*/
#include <iostream> 
#include "rectangle.h"
#include "circle.h"
#include "shape.h"

using namespace std;
#ifndef CURVECUT_H
#define CURVECUT_H

class CurveCut: public Rectangle, public Circle{
    public:
    CurveCut(double x, double y, double z, double s, double r, const char* name);
    double area();
    double perimeter();
    char* getName()const {return Circle::getName();};
    void display();
    






};
#endif