package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static long runRiddle1(File file){
        List<Long> count = getList(file);

        count = simulateDays(80, count);

        long returnValue = 0L;
        for(Long aLong : count){
            returnValue += aLong;
        }

        return returnValue;
    }


    public static long runRiddle2(File file){
        List<Long> count = getList(file);

        count = simulateDays(256, count);

        long returnValue = 0L;
        for(Long aLong : count){
            returnValue += aLong;
        }

        return returnValue;
    }

    public static List<Long> getList(File file){
        List<List<Long>> readLines = ReadFile.readLines(file, s -> {
            List<Long> longs = getListWithZeros(9);

            String[] split = s.split(",");
            for(String s1 : split){
                int i = Integer.parseInt(s1);
                longs.set(i, longs.get(i) + 1);
            }

            return longs;
        });

        return readLines.get(0);
    }


    public static List<Long> simulateDays(int days, List<Long> integers){
        List<Long> ls = getListWithZeros(9);
        for(int i = 0; i < integers.size(); i++)
            ls.set(i, integers.get(i));
        integers = ls;

        for(int i = 0; i < days; i++){
            List<Long> cache = getListWithZeros(9);

            for(int index = 0; index < integers.size(); index++){
                Long integer = integers.get(index);
                if(index == 0){
                    cache.set(6, integer);
                    cache.set(8, integer);
                }else{
                    cache.set(index - 1, cache.get(index - 1) + integer);
                }
            }

            integers = cache;
        }
        return integers;
    }

    public static List<Long> getListWithZeros(int length){
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < length; i++){
            list.add(0L);
        }
        return list;
    }
}
