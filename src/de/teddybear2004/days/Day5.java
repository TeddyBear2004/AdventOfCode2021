package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {
    public static int runRiddle1(File file){
        List<Vent> vents = getVents(file);
        List<Point> points = new ArrayList<>();

        vents.forEach(vent -> points.addAll(getPassingPoints(vent.from, vent.to, false)));
        Map<Point, Integer> map = countPoints(points);

        return (int)map.values().stream().filter(integer -> integer > 1).count();
    }


    public static int runRiddle2(File file){

        List<Vent> vents = getVents(file);
        List<Point> points = new ArrayList<>();

        vents.forEach(vent -> points.addAll(getPassingPoints(vent.from, vent.to, true)));
        Map<Point, Integer> map = countPoints(points);

        return (int)map.values().stream().filter(integer -> integer > 1).count();
    }

    public static Map<Point, Integer> countPoints(List<Point> points){
        Map<Point, Integer> map = new HashMap<>();

        for(Point point : points){
            map.put(point, map.containsKey(point) ? map.get(point) + 1 : 1);
        }

        return map;
    }

    public static List<Vent> getVents(File file){
        return ReadFile.readLines(file, s -> {
            String[] split = s.split(" -> ");
            String[] fromSplit = split[0].split(",");
            String[] toSplit = split[1].split(",");
            Point from = new Point(Integer.parseInt(fromSplit[0]), Integer.parseInt(fromSplit[1]));
            Point to = new Point(Integer.parseInt(toSplit[0]), Integer.parseInt(toSplit[1]));
            return new Vent(from, to);
        });
    }

    public record Vent(Point from, Point to) {}

    public static List<Point> getPassingPoints(Point from, Point to, boolean includeDiagonal){
        List<Point> passing = new ArrayList<>();
        if(from.x == to.x){
            int smallerY;
            int biggerY;
            smallerY = Math.min(from.y, to.y);
            biggerY = Math.max(from.y, to.y);
            for(int y = smallerY; y < biggerY + 1; y++)
                passing.add(new Point(from.x, y));
        }else if(from.y == to.y){
            int smallerX;
            int biggerX;
            smallerX = Math.min(from.x, to.x);
            biggerX = Math.max(from.x, to.x);
            for(int x = smallerX; x < biggerX + 1; x++)
                passing.add(new Point(x, from.y));
        }else if(includeDiagonal){
            int xDifference = from.x < to.x ? 1 : -1;
            int yDifference = from.y < to.y ? 1 : -1;

            Point clonedTo =  (Point)to.clone();
            clonedTo.setLocation(clonedTo.x + xDifference, clonedTo.y + yDifference);
            for(Point point = (Point)from.clone(); !point.equals(clonedTo); point.setLocation(point.x + xDifference, point.y + yDifference))
                passing.add((Point)point.clone());
        }
        return passing;

    }
}
