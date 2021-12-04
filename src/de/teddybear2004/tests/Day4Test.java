package de.teddybear2004.tests;

import de.teddybear2004.days.Day4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class Day4Test {
    @Test
    void runRiddle1(){
        Assertions.assertEquals(4512, Day4.runRiddle1(new File("./src/de/teddybear2004/tests/Day4/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(1924, Day4.runRiddle2(new File("./src/de/teddybear2004/tests/Day4/1.test")));
    }
}