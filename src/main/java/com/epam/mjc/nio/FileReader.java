package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = Paths.get(file.getPath());
        String line;
        String[] str;
        String name = "";
        int age = 0;
        long phone = 0;
        String email = "";
        try(BufferedReader reader = Files.newBufferedReader(path)){
            while ((line = reader.readLine()) != null){
                line = line.replace(System.getProperty("line.separator"), " ");
                str = line.split(" ");
                if(str[0].equals("Name:")){
                    name = str[1];
                }
                if(str[0].equals("Age:")) {
                    age = Integer.parseInt(str[1]);
                }
                if(str[0].equals("Email:")){
                    email = str[1];
                }
                if(str[0].equals("Phone:")) {
                    phone = Long.parseLong(str[1]);
                }

                System.out.println();
            }
        }
        catch (IOException e){
            e.getStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
