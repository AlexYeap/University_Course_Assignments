//circle.cpp
    #include "circle.h"
    #include "shape.h"
    #include "point.h"
    #include <iostream>
    using namespace std;
    #include <math.h>
    #include <iomanip>
    Circle::Circle(double x, double y, double z, const char* name):Shape(x,y,name){
        radius = z;
    }
    double Circle::area(){
        return M_PI * pow(radius,2);
    }
    double Circle::perimeter(){
        return 2 * M_PI * radius;
    }
    double Circle::getr()const{
        return radius;
    }  
    void Circle::setr(double radi){
        radius = radi;
    }
    void Circle::display(){
    cout << "\n" << "Circle name: " << getName() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "X-Coordinate: " << getOrigin().getx() << endl;
    cout << "Y-Coordinate: " << getOrigin().gety() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "Radius: " << getr() << endl;
    cout << "Area: " << area() << endl;
    cout << "Perimeter: " << perimeter()<<endl;
    }