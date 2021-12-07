package de.teddybear2004.tests;

import de.teddybear2004.days.Day6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class Day6Test {
    @Test
    void runRiddle1(){
        Assertions.assertEquals(5934L, Day6.runRiddle1(new File("./src/de/teddybear2004/tests/Day6/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(12L, Day6.runRiddle2(new File("./src/de/teddybear2004/tests/Day6/1.test")));
    }

    @Test
    void simulateDays(){
        //Initial state: 3,4,3,1,2
        List<Long> input = List.of(0L, 1L, 1L, 2L, 1L);
        //After  1 day:  2,3,2,0,1
        List<Long> expected1 = List.of(1L, 1L, 2L, 1L, 0L, 0L, 0L, 0L, 0L);
        //After  2 days: 1,2,1,6,0,8
        List<Long> expected2 = List.of(1L, 2L, 1L, 0L, 0L, 0L, 1L, 0L, 1L);
        //After  3 days: 0,1,0,5,6,7,
        List<Long> expected3 = List.of(2L, 1L, 0L, 0L, 0L, 1L, 1L, 1L, 1L);


        List<Long> actual1 = Day6.simulateDays(1, input);
        List<Long> actual2 = Day6.simulateDays(1, actual1);
        List<Long> actual3 = Day6.simulateDays(1, actual2);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);

    }

    @Test
    void getListWithZeros(){
        List<Long> expected = List.of(0L, 0L, 0L, 0L);
        List<Long> actual = Day6.getListWithZeros(4);
        Assertions.assertEquals(expected, actual);
    }
}