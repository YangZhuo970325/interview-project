package com.algorithm.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    private void inorder(TreeNode root, List list) {
        if (root == null) {
            return ;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    } 
}
