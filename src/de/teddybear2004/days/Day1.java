package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.List;

public class Day1 {

    public static Integer runRiddle1(File file){
        List<Integer> numbers = ReadFile.readLines(file, Integer::parseInt);

        int i = 0;

        for(int i1 = 1; i1 < numbers.size(); i1++)
            if(numbers.get(i1) > numbers.get(i1 - 1))
                i++;

        return i;
    }

    public static Void runRiddle2(File file){
        return null;
    }
}
