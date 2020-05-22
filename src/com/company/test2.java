package com.company;


public class test2 {
    private static int[] colWidth;

    public static void main(String[] args) {
        String[] strings = {"11111", "22222", "333333", "444444", "1", "2", "3", "4", "11", "22", "33", "44"};
        printColumns(strings, 4);
    }

    static void printColumns(String[] strings, int colCnt) {
        getMaxWidth(strings, colCnt);
        for (int i = 0; i < strings.length / colCnt; i++) {//row
            for (int j = 0; j < colCnt; j++) {
                System.out.print(addSpaces(strings[i * colCnt + j], j));
            }
            System.out.println();
        }
    }

    static void getMaxWidth(String[] strings, int colCnt) {
        colWidth = new int[colCnt];
        for (int i = 0; i < colCnt; i++) { //col
            for (int j = i; j < strings.length; j += colCnt) { //ever "colCnt" beginning from "i"
                colWidth[i] = Math.max(colWidth[i], strings[j].length()); // get max width of column
            }
        }
    }

    static String addSpaces(String string, int colNum) {
        StringBuilder sb = new StringBuilder(string);
//        for (int i = 0; i <= colWidth[colNum] - string.length(); i++) {
            sb.append(" ".repeat(colWidth[colNum] - string.length()+1));
//        }
        return sb.toString(); // + 1 white space to divide columns
    }
}
