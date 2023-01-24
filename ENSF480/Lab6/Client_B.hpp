#include <string>
#include <iostream>
using namespace std;
#include "LoginServer.hpp"
#include "User.hpp"
#ifndef CLIENT_B_HPP
#define CLIENT_B_HPP

class Client_B{
    private:
    LoginServer* instance;

    public:
    Client_B();
    void add(string username, string password);
    User* validate(string username, string password);

};
#endif
