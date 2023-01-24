#include <string>
#include <iostream>
using namespace std;
#include "LoginServer.hpp"
#include "User.hpp"
#ifndef CLIENT_A_HPP
#define CLIENT_A_HPP
class Client_A{
    private:
    LoginServer* instance;
    public:
    Client_A();
    void add(string username, string password);
    User* validate(string username, string password);

};
#endif
