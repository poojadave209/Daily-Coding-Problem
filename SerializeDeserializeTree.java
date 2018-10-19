package com.dcp;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserializeTree {

    public static String serializeTree(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        buildString(node, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("#,");
        } else {
            result.append(node.val + ",");
            buildString(node.left, result);
            buildString(node.right, result);
        }
    }

    public static TreeNode deserializeTree(String tree) {
        LinkedList<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(tree.split(",")));
        return buildTree(nodes);
    }

    private static TreeNode buildTree(LinkedList<String> nodes) {
        String val = nodes.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        System.out.println(serializeTree(root));
        System.out.println(root.left.val == deserializeTree(serializeTree(root)).left.val);
    }
}
