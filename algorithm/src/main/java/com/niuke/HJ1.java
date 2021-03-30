package com.niuke;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        if (next.length()<5000){
            String[] s = next.split(" ");
            if (s.length>0){
                String str = s[s.length-1];
                System.out.println(str.length());
            }else {
                System.out.println(0);
            }
        }
    }
}
