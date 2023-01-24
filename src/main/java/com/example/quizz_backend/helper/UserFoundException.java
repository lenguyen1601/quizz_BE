package com.example.quizz_backend.helper;

public class UserFoundException extends Exception {
    public UserFoundException(){
        super("User with this name not found in DB!!!");


    }
    public UserFoundException (String msg)
    {
        super(msg);

    }
}
