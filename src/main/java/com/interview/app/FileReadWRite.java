package com.interview.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadWRite {

    public static boolean writeFiles(String filePath,List<String> inputs ) {
        try {
            BufferedWriter  bufferWriter = new BufferedWriter(new FileWriter(filePath)) ;
            for(String input : inputs) {
                bufferWriter.write(input);
                bufferWriter.newLine();
            }
            bufferWriter.close();
            return true ;
        } catch (Exception ex)  {
          //  ex.printStackTrace();
            return false ;
        }

    }
      public static List<String>  readFile(String filePath ) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)) ;
            List<String> inputs = new ArrayList<String>() ;
            String line = bufferedReader.readLine() ;
            while(null != line) {
                inputs.add(line);
                line = bufferedReader.readLine();
            }
            return inputs ;
        } catch (Exception ex)  {
           ex.printStackTrace();
            return null ;
        }

    }

    public static String readFromConsole() {
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
           String name = reader.readLine();
           return name ;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null ;
        }
    }

    public static void makeSingleDiectory(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void makeMultipleDiectories(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    System.out.println("Multiple directories are created!");
                } else {
                    System.out.println("Failed to create multiple directories");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
