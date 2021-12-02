package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.List;

public class Day2 {

    public static int runRiddle1(File file){
        List<Move> moves = ReadFile.readLines(file, s -> {
            String[] split = s.split(" ");
            return new Move(Direction.valueOf(split[0]), Integer.parseInt(split[1]));
        });

        int horizontal = 0;
        int depth = 0;

        for(Move move : moves){
            switch (move.direction){
                case down -> depth += move.distance;
                case up -> depth -= move.distance;
                case forward -> horizontal += move.distance;
            }
        }

        return horizontal * depth;
    }

    public static int runRiddle2(File file){
        return 0;
    }

    public static record Move(Direction direction, int distance) {

    }

    public enum Direction {
        forward, down, up,
    }
}
