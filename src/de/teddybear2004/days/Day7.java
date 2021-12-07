package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day7 {
    public static long runRiddle1(File file){
        List<Integer> list = getList(file);
        int leastFuel = 0;
        for(Integer integer : Set.copyOf(list)){
            int fuel = 0;

            for(Integer integer1 : list)
                fuel += Math.abs(integer1 - integer);

            if(fuel < leastFuel || leastFuel == 0)
                leastFuel = fuel;
        }
        return leastFuel;
    }


    public static int runRiddle2(File file){
        List<Integer> list = getList(file);
        Set<Integer> integers = Set.copyOf(list);
        int min = integers.stream().min(Integer::compareTo).get();
        int max = integers.stream().max(Integer::compareTo).get();

        int leastFuel = 0;

        for(int i = min; i < max; i++){
            int fuel = 0;

            for(Integer integer1 : list)
                fuel += getSumOfNumbersBefore(Math.abs(integer1 - i));

            if(fuel < leastFuel || leastFuel == 0)
                leastFuel = fuel;
        }
        return leastFuel;
    }

    public static int getSumOfNumbersBefore(int i){
        int result = 0;
        for(int i1 = 0; i1 < i + 1; i1++){
            result += i1;
        }

        return result;
    }

    public static List<Integer> getList(File file){
        List<List<Integer>> readLines = ReadFile.readLines(file, s -> {
            List<Integer> list = new ArrayList<>();

            String[] split = s.split(",");
            for(String s1 : split){
                list.add(Integer.parseInt(s1));
            }

            return list;
        });

        return readLines.get(0);
    }
}
