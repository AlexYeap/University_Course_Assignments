/*  
* File Name: square.h
* Assignment: Lab2
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/2/2022
*/
#include <iostream>
using namespace std;
#include "shape.h"
#include "point.h"
#ifndef SQUARE_H
#define SQUARE_H
class Square:public Shape{
    private:
    double side_a;

    public:
    Square(double x, double y, double z, const char* name);
    double get_side_a()const;
    void set_side_a(double side);
    double area();
    double perimeter();
    void display();
    

};
#endif