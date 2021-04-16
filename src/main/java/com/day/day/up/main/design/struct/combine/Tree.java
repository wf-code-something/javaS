package com.day.day.up.main.design.struct.combine;

public class Tree {

    TreeNode treeNode = null;

    public Tree(String name){
        treeNode = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeA = new TreeNode("nodeA");
        TreeNode nodeB = new TreeNode("nodeB");
        nodeB.add(nodeA);
        tree.treeNode.add(nodeB);
        System.out.println("build is finish");

    }
}
