package com.interview.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> inputs = FileReadWRite.readFile("./resources/input.txt") ;
        inputs = Optional.ofNullable(inputs).orElse(new ArrayList<String>()) ;
        Integer value =  inputs.size() == 0 ? Integer.valueOf(0) : Integer.valueOf(inputs.get(0)) ;
        Calculator calculator = new Calculator(value);
        while (true)
            calculator.run();
    }



}
