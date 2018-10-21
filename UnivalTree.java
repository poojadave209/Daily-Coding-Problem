package com.dcp;

public class UnivalTree {

    public static int countRec(TreeNode tree) {
        Count count = new Count();
        countRec(tree, count);
        return count.getCount();
    }

    private static boolean countRec(TreeNode node, Count c) {
        if (node == null) {
            return true;
        }

        boolean left = countRec(node.left, c);
        boolean right = countRec(node.right, c);

        if (!left || !right) {
            return false;
        }

        if (node.left != null && node.val != node.left.val) {
            return false;
        }

        if (node.right != null && node.val != node.right.val) {
            return false;
        }
        c.addCount(1);
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(countRec(root));
    }
}

class Count {

    private int count;

    public Count() {
        count = 0;
    }

    public void addCount(int delta) {
        count += delta;
    }

    public int getCount() {
        return count;
    }
}
