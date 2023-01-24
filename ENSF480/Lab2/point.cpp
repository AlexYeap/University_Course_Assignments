//point.cpp
#include <iostream>
#include <iomanip>
using namespace std;
#include "point.h"
#include <math.h>
Point::Point(double x, double y){
    xCoordinate = x;
    yCoordinate = y;
    count++;
    idNumber = 1000 + count;
}

double Point::getx()const{
    return xCoordinate;
}
double Point::gety()const{
    return yCoordinate;
}
void Point::setx(double a){
    xCoordinate = a;
 }
void Point::sety(double a){
    yCoordinate = a;
}
void Point::display(){
    cout << fixed;
    cout << setprecision(2);
    cout << "\n" << "X-Coordinate: " << xCoordinate << endl;
    cout << "Y-Coordinate: " << yCoordinate << endl;
}
int Point::count;

int Point::getId()const{
    return idNumber;
}

double Point::distance(Point x){
return (sqrt(pow(x.xCoordinate-xCoordinate,2)+(pow(x.yCoordinate-yCoordinate,2))));
    
}


double Point::distance(Point x, Point y){
    return (sqrt(pow(y.getx()-x.getx(),2))+(pow(y.gety()-x.gety(),2)));
}