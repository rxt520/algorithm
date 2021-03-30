package com.niuke;

import java.util.*;
public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet();
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            for (int j = 0; j < i; j++) {
                set.add(scanner.nextInt());
            }
            set.stream().sorted((o1, o2) -> {
                if (o1<o2){
                    return -1;
                }else {
                    return 1;
                }
            }).forEach(e-> System.out.println(e));
            set.clear();
        }
    }
}
