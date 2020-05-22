package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] strings = {"11111","22222","333333","444444","4","3","2","1"};
        sort(strings,4);
    }

    static String addSpaces(String str,int cnt) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < cnt-str.length() + 1; i++) {  //+1 разделитедь для длинных строк
            sb.append(" ");
        }
        return sb.toString();
    }

    static int[] findColumnsLen(String[] strings, int colCnt) {
        int[] colMaxLength = new int[colCnt];
        for (int j = 0; j < colMaxLength.length; j++) {
            try {
                for (int i = j; i < strings.length; i += colCnt) {
                    if (colMaxLength[j] < strings[i].length()) {
                        colMaxLength[j] = strings[i].length();
                    }
                }
            } catch (IndexOutOfBoundsException ioobe) {
                /*ignore*/
            }
        }
        return colMaxLength;
    }

    static void sort(String[] input, int columnCnt) {
        Arrays.sort(input);
//        Stream<String> stringStream = Stream.of(input);
//        stringStream.map(s -> {
//            s += spaces()
//        });
        int[] colMaxLength = findColumnsLen(input, columnCnt);
        for (int i = 0; i < columnCnt; i++) {
            try {
                for (int j = 0; j < input.length; j += columnCnt) {
                    System.out.printf(addSpaces(input[j], colMaxLength[i]));
                }

            }catch (IndexOutOfBoundsException ioobe){/*ignore*/}
            System.out.println();
        }

    }
}
