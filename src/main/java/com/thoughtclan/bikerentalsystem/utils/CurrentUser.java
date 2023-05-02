package com.thoughtclan.bikerentalsystem.utils;

import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.User;

public class CurrentUser {
    private static final ThreadLocal<User> threadUser = new ThreadLocal<>();


    public static void set(User user) {threadUser.set(user);}

    public static User get(){
        if(threadUser.get() == null){

            throw new EntityNotFoundException("user does not exist currently");

        }
        return threadUser.get();
    }
}
