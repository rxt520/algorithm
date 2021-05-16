package com.niuke;

import java.util.*;

/**
 * @author rxt
 * @version 1.0
 * @date 2021/5/16 23:26
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * 1.set和get方法的时间复杂度为O(1)
 * 2.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 3.当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */
public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU();
        int[][] ops = new int[][]{
                {1,1,1},
                {1,2,2},
                {1,3,2},
                {2,1},
                {1,4,4},
                {2,2}
        };
        int[] lru1 = lru.LRU(ops, 3);
        System.out.println(Arrays.toString(lru1));
    }
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(k);
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1){
                //Set 操作
                if (k == map.size()){
                    //判断是否在map数组里  || 需要先移除最后一个 再进行添加
                    if (!map.containsKey(operators[i][1])) {
                        Integer next = map.keySet().iterator().next();
                        map.remove(next);
                    }else {
                        map.remove(operators[i][1]);
                    }
                }
                map.put(operators[i][1],operators[i][2]);
            }else {
                Integer key = operators[i][1];
                // Get 操作
                Integer integer = map.get(key);
                if (integer == null){
                    list.add(-1);
                }else {
                    list.add(integer);
                    map.remove(key);
                    map.put(key,integer);
                }
            }
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
}
