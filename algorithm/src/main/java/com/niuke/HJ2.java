package com.niuke;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s11 = s.toUpperCase();
        String s22 = s2.toUpperCase();
        int count = 0;
        for (int i = 0; i < s11.length(); i++) {
            if (s22.charAt(0) == (s11.charAt(i))){
                count ++ ;
            }
        }
        System.out.println(count);
    }
}
