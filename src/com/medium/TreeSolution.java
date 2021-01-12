package com.medium;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class TreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1. 如果两个树都为空 肯定相同
        if (p == null && q == null) {
            return true;
        }

        //2. 如果一个为空一个非空 肯定不同
        if (p == null || q == null) {
            return false;
        }

        //两个都非空 但是值不同 也不同
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
    }

    public static void main(String[] args) {

    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}