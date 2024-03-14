package com.erichgamma.api;

import com.erichgamma.api.enums.NavigationOfFunction;
import com.erichgamma.api.enums.NavigationOfPredicate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SQLException {
        while(NavigationOfPredicate.navigate(scanner));

//        NavigationOfConsumer.navigate(scanner);
        //while


//        String a = NavigationOfSupplier.navigate(scanner);
//        while (f.equals("x"));


//        while (!NavigationOfFunction.navigate(scanner).equals("x")) ;
//        while (f.equals("x"));


    }
}