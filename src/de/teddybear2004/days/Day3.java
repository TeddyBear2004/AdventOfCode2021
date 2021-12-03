package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {

    public static int runRiddle1(File file){
        List<byte[]> list = getByteArrays(file);

        byte[] byteMostCommon = new byte[list.get(0).length];
        byte[] byteLeastCommon = new byte[list.get(0).length];

        for(int i = 0; i < list.get(0).length; i++){
            int zeroCount = countBytes(list, (byte)0, i);
            int oneCount = countBytes(list, (byte)1, i);

            if(zeroCount > oneCount){
                byteMostCommon[i] = 0;
                byteLeastCommon[i] = 1;
            }else {
                byteMostCommon[i] = 1;
                byteLeastCommon[i] = 0;
            }
        }

        return byteArrayToInt(byteMostCommon) * byteArrayToInt(byteLeastCommon);
    }

    public static int runRiddle2(File file){
        byte[] byteMostCommon = getByteMostCommon(getByteArrays(file), 0);
        byte[] byteLeastCommon = getByteLeastCommon(getByteArrays(file), 0);

        int leastCommonNumber = byteArrayToInt(byteMostCommon);
        int mostCommonNumber = byteArrayToInt(byteLeastCommon);
        return mostCommonNumber * leastCommonNumber;
    }

    public static byte[] getByteMostCommon(List<byte[]> bytes, int index){
        if(bytes.size() == 1 || index == bytes.get(0).length)
            return bytes.get(0);
        int j = countBytes(bytes, (byte)0, index);
        byte mostUsed = (byte)(bytes.size() / 2 == j ? 0 : bytes.size() / 2 > j ? 0 : 1);
        List<byte[]> toRemove = new ArrayList<>();

        bytes.forEach(s -> {
            if(s[index] == mostUsed){
                toRemove.add(s);
            }
        });
        bytes.removeAll(toRemove);
        return getByteMostCommon(bytes, index + 1);
    }

    public static byte[] getByteLeastCommon(List<byte[]> bytes, int index){
        if(bytes.size() == 1 || index == bytes.get(0).length)
            return bytes.get(0);
        int j = countBytes(bytes, (byte)0, index);
        byte mostUsed = (byte)(bytes.size() / 2 == j ? 1 : bytes.size() / 2 > j ? 1 : 0);
        List<byte[]> toRemove = new ArrayList<>();
        bytes.forEach(s -> {
            if(s[index] == mostUsed){
                toRemove.add(s);
            }
        });
        bytes.removeAll(toRemove);
        return getByteLeastCommon(bytes, index + 1);
    }

    public static int countBytes(List<byte[]> bytes, byte i, int index){
        int count = 0;
        for(byte[] b : bytes)
            if(b[index] == i)
                count++;
        return count;
    }

    public static List<byte[]> getByteArrays(File file){
        return ReadFile.readLines(file, s -> {
            byte[] bytes = new byte[s.length()];
            for(int i = 0; i < s.length(); i++){
                bytes[i] = (byte)(s.charAt(i) == '0' ? 0 : 1);
            }
            return bytes;
        });
    }

    public static int byteArrayToInt(byte[] bytes){
        byte[] reversed = new byte[bytes.length];
        for(int i = 0; i < bytes.length; i++)
            reversed[i] = bytes[bytes.length - i - 1];

        int i = 0;

        for(int j = 0; j < reversed.length; j++){
            i += reversed[j] * Math.pow(2, j);
        }
        return i;
    }
}
