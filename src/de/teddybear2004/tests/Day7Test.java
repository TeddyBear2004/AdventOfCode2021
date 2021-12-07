package de.teddybear2004.tests;

import de.teddybear2004.days.Day7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class Day7Test {
    @Test
    void runRiddle1(){
        Assertions.assertEquals(37, Day7.runRiddle1(new File("./src/de/teddybear2004/tests/Day7/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(168, Day7.runRiddle2(new File("./src/de/teddybear2004/tests/Day7/1.test")));
    }

    @Test
    void getSumOfNumbersBefore(){
        Assertions.assertEquals(66, Day7.getSumOfNumbersBefore(11));
        Assertions.assertEquals(10, Day7.getSumOfNumbersBefore(4));
        Assertions.assertEquals(6, Day7.getSumOfNumbersBefore(3));
        Assertions.assertEquals(15, Day7.getSumOfNumbersBefore(5));
        Assertions.assertEquals(1, Day7.getSumOfNumbersBefore(1));
    }
}