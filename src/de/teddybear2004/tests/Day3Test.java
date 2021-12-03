package de.teddybear2004.tests;

import de.teddybear2004.days.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class Day3Test {

    @Test
    void getByteMostCommon(){
        List<byte[]> byteArrays = Day3.getByteArrays(new File("./src/de/teddybear2004/tests/Day3/1.test"));
        Assertions.assertArrayEquals(new byte[]{1, 0, 1, 1, 1}, Day3.getByteMostCommon(byteArrays, 0));
    }

    @Test
    void getByteLeastCommon(){
        List<byte[]> byteArrays = Day3.getByteArrays(new File("./src/de/teddybear2004/tests/Day3/1.test"));
        Assertions.assertArrayEquals(new byte[]{0, 1, 0, 1, 0}, Day3.getByteLeastCommon(byteArrays, 0));
    }

    @Test
    void byteArrayToInt(){


        Assertions.assertEquals(0b10111, Day3.byteArrayToInt(new byte[]{1, 0, 1, 1, 1}));
        Assertions.assertEquals(0b1011100, Day3.byteArrayToInt(new byte[]{1, 0, 1, 1, 1, 0, 0}));
    }

    @Test
    void runRiddle1(){
        Assertions.assertEquals(198, Day3.runRiddle1(new File("./src/de/teddybear2004/tests/Day3/1.test")));
    }

    @Test
    void runRiddle2(){
        Assertions.assertEquals(230, Day3.runRiddle2(new File("./src/de/teddybear2004/tests/Day3/1.test")));
    }

    @Test
    void getByteArrays(){
        List<byte[]> byteArrays = Day3.getByteArrays(new File("./src/de/teddybear2004/tests/Day3/1.test"));
        List<byte[]> expected = List.of(
                new byte[]{0, 0, 1, 0, 0},
                new byte[]{1, 1, 1, 1, 0},
                new byte[]{1, 0, 1, 1, 0},
                new byte[]{1, 0, 1, 1, 1},
                new byte[]{1, 0, 1, 0, 1},
                new byte[]{0, 1, 1, 1, 1},
                new byte[]{0, 0, 1, 1, 1},
                new byte[]{1, 1, 1, 0, 0},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{1, 1, 0, 0, 1},
                new byte[]{0, 0, 0, 1, 0},
                new byte[]{0, 1, 0, 1, 0});
        Assertions.assertArrayEquals(expected.toArray(), byteArrays.toArray());
    }

    @Test
    void countBytes(){
        List<byte[]> byteArrays = Day3.getByteArrays(new File("./src/de/teddybear2004/tests/Day3/1.test"));
        Assertions.assertEquals(7, Day3.countBytes(byteArrays, (byte)1, 0));
        Assertions.assertEquals(5, Day3.countBytes(byteArrays, (byte)1, 1));
        Assertions.assertEquals(8, Day3.countBytes(byteArrays, (byte)1, 2));
        Assertions.assertEquals(7, Day3.countBytes(byteArrays, (byte)1, 3));
        Assertions.assertEquals(5, Day3.countBytes(byteArrays, (byte)1, 4));

    }
}