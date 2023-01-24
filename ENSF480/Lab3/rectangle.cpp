//rectangle.cpp
#include <iostream>
using namespace std;
#include "rectangle.h"
#include <iomanip>
    Rectangle::Rectangle (double x, double y, double z, double s, const char* name):Square(x,y,z,name), Shape(x,y,name){
        side_b = s;
    }
    double Rectangle::area(){
        return get_side_a() * get_side_b();
    }
    double Rectangle::perimeter(){
        return ((2 * get_side_a()) + (2 * get_side_b()));

    }

    void  Rectangle::display(){
    cout << "\n" << "Rectangle name: " << getName() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "X-Coordinate: " << getOrigin().getx() << endl;
    cout << "Y-Coordinate: " << getOrigin().gety() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "Side A: " << get_side_a() << endl;
    cout << "Side B: " << get_side_b() << endl;
    cout << "Area: " << area() << endl;
    cout << "Perimeter: " << perimeter()<<endl;
    }
    double  Rectangle::get_side_b(){
        return side_b;
    }
    void  Rectangle::set_side_b(double side){
        side_b = side;
    }
