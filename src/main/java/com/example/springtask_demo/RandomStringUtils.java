package com.example.springtask_demo;

import java.util.Random;

public class RandomStringUtils {

    private final static char[] chs = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '!', '@', '#', '$', '%', '^', '&', '*',
            '-', '+', '=', '?', '~'
    };

    private final static int MIN_LEN = 8;
    private final static Random ran = new Random();

    public static String randomString(int len) {
        len = Math.max(len, MIN_LEN);
        StringBuilder sbu = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sbu.append(chs[ran.nextInt(chs.length)]);
        }

        return sbu.toString();
    }
}
