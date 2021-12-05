package de.teddybear2004.tests;

import de.teddybear2004.days.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Day5Test {
    @Test
    void runRiddle1(){
        Assertions.assertEquals(5, Day5.runRiddle1(new File("./src/de/teddybear2004/tests/Day5/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(12, Day5.runRiddle2(new File("./src/de/teddybear2004/tests/Day5/1.test")));
    }

    @Test
    void getPassingPoints(){
        List<Point> expected = new ArrayList<>();
        expected.add(new Point(1, 1));
        expected.add(new Point(1, 2));
        expected.add(new Point(1, 3));
        expected.add(new Point(1, 4));

        Assertions.assertEquals(expected, Day5.getPassingPoints(new Point(1, 1), new Point(1, 4), false));
        Assertions.assertEquals(expected, Day5.getPassingPoints(new Point(1, 4), new Point(1, 1), false));

        expected = new ArrayList<>();
        expected.add(new Point(1, 1));
        expected.add(new Point(2, 1));
        expected.add(new Point(3, 1));
        expected.add(new Point(4, 1));

        Assertions.assertEquals(expected, Day5.getPassingPoints(new Point(1, 1), new Point(4, 1), false));
        Assertions.assertEquals(expected, Day5.getPassingPoints(new Point(4, 1), new Point(1, 1), false));

        expected = new ArrayList<>();
        expected.add(new Point(1,1));
        expected.add(new Point(2,2));
        expected.add(new Point(3,3));
        Assertions.assertEquals(expected,Day5.getPassingPoints(new Point(1,1),new Point(3,3),true));
        expected = new ArrayList<>();
        expected.add(new Point(3,3));
        expected.add(new Point(2,2));
        expected.add(new Point(1,1));
        Assertions.assertEquals(expected,Day5.getPassingPoints(new Point(3,3),new Point(1,1),true));
    }
}