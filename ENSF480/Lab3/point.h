/*  
* File Name: point.h
* Assignment: Lab3
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 10/10/2022
*/
#include <iostream>

#ifndef POINT_H
#define POINT_H

using namespace std;
class Point{
    protected:
    double xCoordinate;
    double yCoordinate;
    int idNumber;
    static int count;


    public:
    
    Point(double x, double y);
    double getx() const;                         
    double gety() const;                       
    void setx(double a);
    void sety(double a);
    void display();
    int getId()const;
    static int getCounter(){return count;};
    double distance(Point x);
    static double distance(Point x, Point y);




};
#endif