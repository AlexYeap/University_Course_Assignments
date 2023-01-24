/*  
* File Name: shape.h
* Assignment: Lab2
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/2/2022
*/
#include <iostream>
using namespace std;
#include "point.h"

#ifndef SHAPE_H
#define SHAPE_H

class Shape{
    protected:
        Point origin;
        char* shapeName;

    public:
        Shape(Point ori, const char* name);
        Shape(double x, double y, const char* name);
        Point getOrigin()const;
        char* getname()const;
        virtual void display();
        double distance(Shape& other);
        static double distance(Shape& the_shape, Shape& other);
        void move(double dx, double dy);
        ~Shape();


};
#endif