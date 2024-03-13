package com.erichgamma.api.enums;


import java.util.function.Predicate;

enum UserRoute{
    EXIT, SAVE, LOGIN, SERCHID, UPPASS, DELETE, LIST, NAME, JOB, COUNT, TOUCH, RM


    ;
    private final String name;
    private final Predicate<String> predicate;

    UserRoute(String name, Predicate<String> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

}


public class UserRouter {


}
