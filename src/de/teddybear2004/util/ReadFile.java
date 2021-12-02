package de.teddybear2004.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReadFile {
    public static <T> List<T> readLines(File file, Function<String, T> converter){
        ArrayList<T> objects = new ArrayList<>();

        if(file.isDirectory())
            return objects;

        try{
            String line;
            BufferedReader reader = new java.io.BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null)
                objects.add(converter.apply(line));
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return objects;
    }
}
