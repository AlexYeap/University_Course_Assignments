#include <string>
#include <vector>
#include <iostream>
using namespace std;
#include "User.hpp"
#ifndef LOGINSERVER_HPP
#define LOGINSERVER_HPP
class LoginServer{
    private:
    vector<User> users;
    static LoginServer* instance;
    public:
    LoginServer();
    LoginServer(const LoginServer &src);
    LoginServer operator =(const LoginServer &rhs);
    static LoginServer* getInstance();
    void add(string username, string password);
    User* validate(string username, string password);

};
#endif