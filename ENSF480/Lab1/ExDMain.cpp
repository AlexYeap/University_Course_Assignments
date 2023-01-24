//#include "human.h"
//#include "point.h"
#include "human_program.h"
#include <assert.h>
#include <cstring>
#include <iostream>

using namespace std;

int main()
{
	double x = 2000, y = 3000;
	Human h("Ken Lai", x , y); 
    h.display();
	return 0;
}
