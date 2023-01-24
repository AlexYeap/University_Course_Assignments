    #include <iostream>
    #include <string.h>
    using namespace std;
    #include"LoginServer.hpp"
    LoginServer* LoginServer::instance;

    LoginServer::LoginServer(){
        
    }
    LoginServer::LoginServer(const LoginServer &src){
        this->users = src.users;
        this->instance = src.instance;
    }
    LoginServer LoginServer::operator =(const LoginServer &rhs){
        this->users = rhs.users;
        this->instance = rhs.instance;
        return *this;
    }
    LoginServer* LoginServer::getInstance(){
        if(instance == NULL){
            instance = new LoginServer();
        }
        return instance;
    }
    void LoginServer::add(string username, string password){
        for(unsigned int i = 0; i < users.size(); i++){
            if (users[i].username == username){
                return;
            }
        }
        User temp;
        temp.username= username;
        temp.password = password;
        users.push_back(temp);

    }
    User* LoginServer::validate(string username, string password){

        for(unsigned int i = 0; i < users.size(); i++){
            if (users[i].username == username && users[i].password == password){
                return &users[i];
            }
        }
        return nullptr;
    }

