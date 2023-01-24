#include <string>
#include <iostream>
using namespace std;
#include "Client_A.hpp"
  
    Client_A::Client_A(){
        instance = LoginServer::getInstance();
    }
    void Client_A::add(string username, string password){
        instance->add(username,password);
    }
    User*  Client_A::validate(string username, string password){
        return this->instance->validate(username,password);
    }

