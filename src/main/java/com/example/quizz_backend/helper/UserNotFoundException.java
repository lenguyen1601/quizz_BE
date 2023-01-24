package com.example.quizz_backend.helper;

public class UserNotFoundException extends Exception{
     public UserNotFoundException(){
         super("user with this username is already there in DB!! try with anothe name");


     }
     public UserNotFoundException (String msg)
     {
         super(msg);

     }
}
