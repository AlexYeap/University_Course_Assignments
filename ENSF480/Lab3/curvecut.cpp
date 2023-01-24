//curvecut.cpp
#include "curvecut.h"
using namespace std;
#include <iostream>
#include <math.h>
#include <iomanip>
    CurveCut::CurveCut(double x, double y, double z, double s, double r, const char* name):Rectangle(x,y,z,s,name),Circle(x,y,r,name),Shape(x,y,name){  
        if(r >= z || r >= s){
        exit(1);
        }
    }

    double CurveCut::area(){
        return ((get_side_a() * get_side_b()) - ((M_PI * pow(getr(),2))/4));
    }
    double CurveCut::perimeter(){
        return (((2 * get_side_a() + 2 * get_side_b() - 2 * getr()) + ((2 * M_PI * getr()) / 4)));
    }
    void CurveCut::display(){
    cout << "\n" << "CurveCut name: " << getName() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "X-Coordinate: " << getOrigin().getx() << endl;
    cout << "Y-Coordinate: " << getOrigin().gety() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "Width: " << get_side_a() << endl;
    cout << "Length: " << get_side_b()<<endl;
    cout << "Radius of the cut. " << getr() << endl;

    }
