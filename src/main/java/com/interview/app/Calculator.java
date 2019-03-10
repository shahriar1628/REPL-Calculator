package com.interview.app;

import java.util.Arrays;

public class Calculator {
    private static Integer value ;
    public Calculator(Integer initValue) {
        value = initValue ;
    }

    public Calculator() {

    }

    public static Integer getValue() {
        return value;
    }

    public static void setValue(Integer val) {
        synchronized (value) {
            value = val ;
        }
    }

    public  void run() {
        try {
            String command = FileReadWRite.readFromConsole();
            String[] args = command.split(" ") ;
            String action = args[0] ;
            String[] params = args.length >1 ? Arrays.copyOfRange(args,1,args.length) : new String[0] ;
            String output = Action.invokeMethod(action,params) ;
            System.out.println(output) ;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
