package de.teddybear2004.tests;

import de.teddybear2004.days.Day9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Day9Test {
    @Test
    void runRiddle1(){
        Assertions.assertEquals(15, Day9.runRiddle1(new File("./src/de/teddybear2004/tests/Day9/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(1134, Day9.runRiddle2(new File("./src/de/teddybear2004/tests/Day9/1.test")));
    }

    @Test
    void getMinNeighbour(){
        List<List<Integer>> inputList = new ArrayList<>();
        for(int[] its : new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}){
            List<Integer> row = new ArrayList<>();
            for(int anInt : its){
                row.add(anInt);
            }
            inputList.add(row);
        }

        Assertions.assertEquals(new Day9.IntLocation(2, 0, 1), Day9.getMinNeighbor(inputList, 0, 0));
        Assertions.assertEquals(new Day9.IntLocation(2, 0, 1), Day9.getMinNeighbor(inputList, 1, 1));
        Assertions.assertEquals(new Day9.IntLocation(6, 1, 2), Day9.getMinNeighbor(inputList, 2, 2));
        Assertions.assertEquals(new Day9.IntLocation(5, 1, 1), Day9.getMinNeighbor(inputList, 2, 1));
        Assertions.assertEquals(new Day9.IntLocation(1, 0, 0), Day9.getMinNeighbor(inputList, 1, 0));
        Assertions.assertEquals(new Day9.IntLocation(1, 0, 0), Day9.getMinNeighbor(inputList, 0, 1));
    }
}