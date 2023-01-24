/*  
* File Name: shape.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
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
        virtual char* getName()const;
        virtual void display();
        double distance(Shape& other);
        static double distance(Shape& the_shape, Shape& other);
        virtual double area(){return 0;};
        virtual double perimeter(){return 0;};
        void move(double dx, double dy);
        ~Shape();


};
#endif