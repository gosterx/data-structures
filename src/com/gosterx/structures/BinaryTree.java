package com.gosterx.structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    public ArrayList<Integer> traverseDFS() {
        ArrayList<Integer> array = new ArrayList<>();
        return traverseDFS(array, root);
    }

    private ArrayList<Integer> traverseDFS(ArrayList<Integer> array, Node node) {
        array.add(node.value);

        if (node.left != null) {
            traverseDFS(array, node.left);
        }

        if (node.right != null) {
            traverseDFS(array, node.right);
        }

        return array;
    }

    private ArrayList<Integer> traverseBFS() {
        ArrayList<Integer> array = new ArrayList<>();
        return traverseBFS(array);
    }

    private ArrayList<Integer> traverseBFS(ArrayList<Integer> array) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            array.add(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        ArrayList<Integer> traversedDFS = tree.traverseDFS();
        ArrayList<Integer> traversedBFS = tree.traverseBFS();

        traversedDFS.forEach(element -> System.out.print(element + " "));
        System.out.println();
        traversedBFS.forEach(element -> System.out.print(element + " "));
    }
}
