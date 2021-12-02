package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.List;

public class Day1 {

    public static int runRiddle1(File file){
        List<Integer> numbers = ReadFile.readLines(file, Integer::parseInt);

        int sum = 0;

        for(int i = 1; i < numbers.size(); i++)
            if(numbers.get(i) > numbers.get(i - 1))
                sum++;

        return sum;
    }

    public static int runRiddle2(File file){
        List<Integer> numbers = ReadFile.readLines(file, Integer::parseInt);

        int sum = -1;


        int last = 0;
        for(int i = 2; i < numbers.size(); i++){
            int cache = numbers.get(i) + numbers.get(i - 1) + numbers.get(i - 2);

            if(cache > last)
                sum++;

            last = cache;
        }

        return sum;
    }
}
