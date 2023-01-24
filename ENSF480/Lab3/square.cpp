#include "point.h"
#include "square.h"
#include "shape.h"
#include <iostream>
#include <iomanip>
using namespace std;

    Square::Square(double x, double y, double z, const char* name):Shape(x,y,name){
        side_a = z;
    }
    double Square::get_side_a()const{
        return side_a;
    }
    void Square::set_side_a(double side){
        side_a = side;
    }
    double Square::area(){
        return get_side_a() * get_side_a();
    }
    double Square::perimeter(){
        return (get_side_a() * 4);
    }
    void Square::display(){
    cout << "\n" << "Square name: " << getName() << endl;
    cout << fixed;
    cout << setprecision(2);
    cout << "X-Coordinate: " << getOrigin().getx() << endl;
    cout << "Y-Coordinate: " << getOrigin().gety() << endl;
    cout << "Side A: " << get_side_a() << endl;
    cout << "Area: " << area() << endl;
    cout << "Perimeter: " << perimeter()<<endl;
    }