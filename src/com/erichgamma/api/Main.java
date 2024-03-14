package com.erichgamma.api;

import com.erichgamma.api.enums.NavigationOfConsumer;
import com.erichgamma.api.enums.NavigationOfFunction;
import com.erichgamma.api.enums.NavigationOfPredicate;
import com.erichgamma.api.enums.NavigationOfSupplier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException, SQLException {

//        NavigationOfConsumer.navigate(scanner);
        //while


//        String a = NavigationOfSupplier.navigate(scanner);
//        while (f.equals("x"));


        String b = NavigationOfFunction.navigate(scanner);
        while (!b.equals("x"));
//        while (f.equals("x"));


//        while(NavigationOfPredicate.navigate(scanner));


    }
}