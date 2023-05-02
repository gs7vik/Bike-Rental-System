package com.thoughtclan.bikerentalsystem.utils;

import com.thoughtclan.bikerentalsystem.models.User;
import org.apache.velocity.exception.ResourceNotFoundException;

public class CurrentUser {
    private static final ThreadLocal<User> threadUser = new ThreadLocal<User>();

    public static void set(User user) {threadUser.set(user);}

    public static User get(){
        if(threadUser.get() == null){
            throw new ResourceNotFoundException("user does not exist currently");
        }
        return threadUser.get();
    }
}
