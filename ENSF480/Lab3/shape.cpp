// shape.cpp
#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;
#include "point.h"
#include "square.h"
#include "shape.h"
    Shape::Shape(Point ori, const char* name):origin(ori){
        shapeName = new char[strlen(name)+1];
        strcpy(shapeName, name);
    }
    Shape::Shape(double x, double y, const char* name):origin(Point(x,y)){
        shapeName = new char[strlen(name)+1];
        strcpy(shapeName, name);
    }
    Shape::~Shape(){
        delete [] shapeName;
    } 
    Point Shape::getOrigin()const{
        return origin;
    }
    char* Shape::getName()const{
        return shapeName;
    }
    void Shape::display(){
        cout << "Shape Name:" << shapeName << ".\n";
        cout << "X-coordinate:" << origin.getx()<< ".\n";
        cout << "Y-coordinate:" << origin.gety()<< ".\n";
    }
    double Shape::distance(Shape& other){
        return origin.distance(other.origin);
    }
    double Shape::distance(Shape& the_shape, Shape& other){
        return (sqrt(pow(other.origin.getx()-the_shape.origin.getx(),2))+(pow(other.origin.gety()-the_shape.origin.gety(),2)));
    }
    void Shape::move(double dx, double dy){
        origin.setx(origin.getx()+dx);
        origin.sety(origin.gety()+dy);
    }