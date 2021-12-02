package de.teddybear2004.tests;

import de.teddybear2004.days.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class Day2Test {

    @Test
    void runRiddle1(){
        Assertions.assertEquals(150, Day2.runRiddle1(new File("./src/de/teddybear2004/tests/Day2/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(900, Day2.runRiddle2(new File("./src/de/teddybear2004/tests/Day2/1.test")));
    }
}