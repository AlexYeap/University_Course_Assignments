#include <string>
#include <iostream>
using namespace std;
#include "Client_B.hpp"
    Client_B::Client_B(){
        instance = LoginServer::getInstance();
    }
    void Client_B::add(string username, string password){
        this->instance->add(username,password);
    }
    User* Client_B::validate(string username, string password){
        return this->instance->validate(username,password);
    }