package com.dynamic;


/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
 * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class GiveChange {
    //5美元个数
    static int dollars5 = 0;
    //10美元个数
    static int dollars10 = 0;

    public static void main(String[] args) {
        //账单bills
//        int[] bills  = new int[]{5,5,5,5,5,5,5,5,5,5,10,20,20,20,20,10,10};
        int[] bills  = new int[]{5,10,5,5,5,20,5,5,10,5};
        boolean solution = solution(bills);
        System.out.println(solution);
    }

    public static boolean solution(int[] bills){
        for (int i = 0; i < bills.length; i++) {
            boolean b = giveChange(bills, i);
            if (!b){
                return false;
            }
        }
        return true;
    }

    public static boolean giveChange(int[] bills,int n){
        int coins = bills[n];
        if (coins == 5){
            dollars5++;
        }else if (bills[n] == 10 && dollars5>0){
            //10元解决方案
            dollars10++;
            dollars5--;
        }else if (bills[n] == 20){
            //20美元的解决方案
            if (dollars10>0 && dollars5>0){
                dollars10--;
                dollars5--;
            }else if (dollars5 >=3){
                dollars5 = dollars5 - 3;
            }else {
                return false;
            }
        }else {
            return false;
        }
        return true;
    }
}
