package com.interview.app;

import javax.swing.text.html.Option;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Action {

    public Action() {

    }

    public String sum(String[] args) {
        try {
            Integer value = Calculator.getValue();
                Calculator.setValue(value + Integer.valueOf(args[0]));
                writeIntoFile(Calculator.getValue().toString());
            return Calculator.getValue().toString();
        } catch ( Exception ex) {
            //ex.printStackTrace();
            return Calculator.getValue().toString();
        }
    }


    public String sub(String[] args) {
        try {
            Integer value = Calculator.getValue();
            Calculator.setValue(value - Integer.valueOf(args[0]));
            writeIntoFile(Calculator.getValue().toString());
            return Calculator.getValue().toString();
        } catch ( Exception ex) {
            //ex.printStackTrace();
            return Calculator.getValue().toString();
        }
    }

    public  String show(String[] args) {
        try {
            return Calculator.getValue().toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public  String clear(String[] args) {
        try {
            Calculator.setValue(0);
            writeIntoFile(Calculator.getValue().toString());
            return Calculator.getValue().toString();
        } catch (Exception ex)  {
            return Calculator.getValue().toString();
        }
    }

    public void exit(String[] args) {
        try{
            System.exit(0);
        } catch ( Exception ex)  {
        }
    }


    private void writeIntoFile(String output) {
        try {
            List<String> outputs = new ArrayList<String >(){{add(output);}};
            FileReadWRite.writeFiles("./resources/input.txt",outputs);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
    }


    public static String invokeMethod(String methodName,String args[]) {
        try {

            Class<?> callingClass = Class.forName("com.interview.app.Action");
            Method callingMethod ;
            callingMethod = callingClass.getDeclaredMethod(methodName,String[].class);
            String output = (String) callingMethod.invoke(callingClass.newInstance(),new Object[]{args});
            return Optional.ofNullable(output).orElse("") ;
        } catch(Exception ex) {
            ex.printStackTrace();
            return "invalid command";
        }
    }


}
