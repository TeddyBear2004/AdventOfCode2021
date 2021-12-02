package de.teddybear2004.tests;

import de.teddybear2004.days.Day1;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.io.File;

class Day1Test {

    @Test
    void runRiddle1(){
        Assertions.assertEquals(7, Day1.runRiddle1(new File("./src/de/teddybear2004/tests/Day1/1.test")));
    }

    @Test
    void runRiddle2(){
    }
}