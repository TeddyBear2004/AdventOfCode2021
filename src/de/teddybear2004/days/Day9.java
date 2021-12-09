package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class Day9 {
    public static long runRiddle1(File file){
        List<List<Integer>> lines = getLines(file);


        List<Integer> values = findLocalMinima(lines);
        int count = 0;

        for(Integer value : values){
            count += value + 1;
        }
        return count;
    }


    public static int runRiddle2(File file){
        List<List<Integer>> lines = getLines(file);
        List<Integer> basinSizes = getBasinSizes(lines);
        basinSizes.sort((o1, o2) -> Integer.compare(o2, o1));
        return basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2);
    }

    public static List<Integer> getBasinSizes(List<List<Integer>> array){
        List<Integer> basinSizes = new ArrayList<>();
        Set<Point> alreadyChecked = new HashSet<>();

        for(int i = 0; i < array.size(); i++){
            for(int j = 0; j < array.get(i).size(); j++){
                Point point = new Point(i, j);
                if(alreadyChecked.contains(point) || array.get(i).get(j) == 9)
                    continue;
                Set<Point> currentBasin = new HashSet<>();
                scanBasin(array, alreadyChecked, point, currentBasin);
                basinSizes.add(currentBasin.size());
            }
        }
        return basinSizes;
    }


    public static List<Integer> findLocalMinima(List<List<Integer>> array){
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            for(int i1 = 0; i1 < array.get(i).size(); i1++){
                int current = array.get(i).get(i1);
                if(current < getMinNeighbor(array, i, i1).value){
                    values.add(current);
                }
            }
        }
        return values;
    }

    public static void scanBasin(List<List<Integer>> array, Set<Point> alreadyChecked, Point point, Set<Point> currentBasin){
        for(int i = -1; i < 2; i += 2){

            Point[] points = new Point[]{
                    new Point(point.x + i, point.y),
                    new Point(point.x, point.y + i)
            };

            for(int j = 0; j < 2; j++){
                Point cache = points[j];

                if(cache.x < 0 || cache.x >= array.size() || cache.y < 0 || cache.y >= array.get(cache.x).size())
                    continue;

                if(array.get(cache.x).get(cache.y) != 9){
                    if(alreadyChecked.add(cache)){
                        currentBasin.add(cache);
                        scanBasin(array, alreadyChecked, cache, currentBasin);
                    }
                }
            }
        }
    }

    public static IntLocation getMinNeighbor(List<List<Integer>> array, int i, int j){
        IntLocation min = new IntLocation(Integer.MAX_VALUE, -1, -1);

        for(int i1 = -1; i1 < 2; i1 += 2)
            if(i + i1 >= 0 && i + i1 < array.size() && j >= 0 && j < array.get(i).size())
                if(array.get(i + i1).get(j) < min.value)
                    min = new IntLocation(array.get(i + i1).get(j), i + i1, j);
        for(int j1 = -1; j1 < 2; j1 += 2)
            if(i >= 0 && i < array.size() && j + j1 >= 0 && j + j1 < array.get(i).size())
                if(array.get(i).get(j + j1) < min.value)
                    min = new IntLocation(array.get(i).get(j + j1), i, j + j1);
        return min;
    }

    public static List<List<Integer>> getLines(File file){
        return ReadFile.readLines(file, s ->
                Arrays.stream(s.split(""))
                        .map(Integer::parseInt).toList());
    }

    public record IntLocation(int value, int i, int j) {}
}
