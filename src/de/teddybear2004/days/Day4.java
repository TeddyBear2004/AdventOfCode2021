package de.teddybear2004.days;

import de.teddybear2004.util.ReadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    public static int runRiddle1(File file){
        List<List<Integer>> readLines = getRawInput(file);
        List<Integer> numbers = getNumbersFromRaw(readLines);
        readLines.remove(0);

        List<BingoField> bingoFields = getBingoFieldsFromRaw(readLines);

        for(Integer number : numbers){
            for(BingoField bingoField : bingoFields){
                bingoField.setMarked(number);
                if(bingoField.isBingo()){
                    int score = bingoField.calculateWinScore(number);
                    if(score != 0)
                        return score;
                }
            }
        }

        return 0;
    }

    public static int runRiddle2(File file){
        List<List<Integer>> readLines = getRawInput(file);
        List<Integer> numbers = getNumbersFromRaw(readLines);
        readLines.remove(0);

        List<BingoField> bingoFields = getBingoFieldsFromRaw(readLines);


        for(int i = 0, numbersSize = numbers.size(); i < numbersSize; i++){
            Integer number = numbers.get(i);
            List<BingoField> toRemove = new ArrayList<>();
            for(BingoField bingoField : bingoFields){
                bingoField.setMarked(number);
                if(bingoField.isBingo()){
                    if(bingoFields.size() == 1){
                        return bingoField.calculateWinScore(number);
                    }
                    toRemove.add(bingoField);
                }
            }
            bingoFields.removeAll(toRemove);
        }


        return 0;

    }

    public static List<BingoField> getBingoFieldsFromRaw(List<List<Integer>> readLines){
        List<BingoField> bingoFields = new ArrayList<>();
        int[][] ints = null;

        readLines.add(null);
        for(int i = 0; i < readLines.size(); i++){
            List<Integer> readLine = readLines.get(i);
            if(readLine == null){
                if(ints != null)
                    bingoFields.add(new BingoField(ints));
                ints = new int[5][5];
                continue;
            }
            for(int j = 0; j < ints.length; j++){
                int[] anInt = ints[j];
                int sum = 0;
                for(int i1 : anInt){
                    sum += i1;
                }

                if(sum == 0){
                    ints[j] = new int[5];
                    for(int i1 = 0; i1 < ints[j].length; i1++)
                        ints[j][i1] = readLine.get(i1);
                    break;
                }
            }

        }
        return bingoFields;
    }

    public static List<Integer> getNumbersFromRaw(List<List<Integer>> readLines){
        return new ArrayList<>(readLines.get(0));
    }

    public static List<List<Integer>> getRawInput(File file){
        return ReadFile.readLines(file, s -> {
            if(s.contains(",")){
                return Arrays.stream(s.split(",")).map(Integer::parseInt).toList();
            }
            if(s.equals("")){
                return null;
            }
            return Arrays.stream(s.split(" ")).filter(s1 -> !s1.equals("")).map(Integer::parseInt).toList();
        });
    }

    public static class BingoField {
        public int[][] field;
        public boolean[][] marked;

        public BingoField(int[][] field){
            this.field = field;
            this.marked = new boolean[this.field.length][this.field[0].length];
            for(int i = 0; i < this.field.length; i++){
                for(int j = 0; j < this.field[i].length; j++){
                    this.marked[i][j] = false;
                }
            }
        }

        public void setMarked(int number){
            for(int i = 0; i < this.field.length; i++){
                for(int j = 0; j < this.field[i].length; j++){
                    if(this.field[i][j] == number){
                        this.marked[i][j] = true;
                    }
                }
            }
        }

        public int calculateWinScore(int lastNumber){
            int score = 0;
            for(int i = 0; i < marked.length; i++)
                for(int j = 0; j < marked[i].length; j++)
                    if(!marked[i][j])
                        score += field[i][j];
            return score * lastNumber;
        }

        public boolean isBingo(){
            for(int i = 0; i < this.marked.length; i++){
                boolean row = true;
                boolean column = true;
                for(int j = 0; j < this.marked[i].length; j++){
                    boolean b = this.marked[i][j];
                    row &= b;
                    b = this.marked[j][i];
                    column &= b;
                }
                if(row || column)
                    return true;
            }

            return false;
        }

        public boolean[][] getMarked(){
            return marked;
        }

        public int[][] getField(){
            return field;
        }

        @Override
        public String toString(){
            return "BingoField{" +
                    "field=" + Arrays.toString(field) +
                    ", marked=" + Arrays.toString(marked) +
                    '}';
        }
    }
}
