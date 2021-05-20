package com.niuke;

import java.util.ArrayList;

/**
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class ThreeOrders {
    public static void main(String[] args) {
        ThreeOrders threeOrders = new ThreeOrders();
        TreeNode treeNode = new TreeNode();

    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        // write code here
        //先根
        preRoot(root,list);
        int size = list.size();
        if (size == 0){
            return new int[0][0];
        }
        int[][] ints =  new int[3][size];
        ints[0] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();
        //中根
        midRoot(root,list);
        ints[1] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();
        //后根
        afterRoot(root,list);
        ints[2] = list.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    private void preRoot(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        // root
        list.add(root.val);
        // left
        preRoot(root.left,list);
        // right
        preRoot(root.right,list);
    }

    private void midRoot(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        // left
        midRoot(root.left,list);
        // root
        list.add(root.val);
        // right
        midRoot(root.right,list);
    }

    private void afterRoot(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        // left
        afterRoot(root.left,list);
        // right
        afterRoot(root.right,list);
        // root
        list.add(root.val);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

