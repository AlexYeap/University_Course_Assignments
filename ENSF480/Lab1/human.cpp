
#include <assert.h>
#include <iostream>
#include <stdlib.h>
#include <cstring>
using namespace std;
#include "human.h"
#include "point.h"

    Human::Human(const char* nam="", double x=0, double y=0): name(new char[strlen(nam)+1]) {
        strcpy(this ->name, nam);
        location.set_x(x);
        location.set_y(y);
    }
    
    char* Human::get_name() {return name;} 
            
    void Human::set_name(char* name) {                  
        this->name = new char[strlen(name)+1];        
        strcpy(this ->name, name);
    }
   
    Point Human::get_point()const {return location;}
    
    void Human::display() {                      
        cout << "Human Name: " << name << "\nHuman Location: "
        << location.get_x() << " ,"
        << location.get_y() << ".\n" << endl;
    }
