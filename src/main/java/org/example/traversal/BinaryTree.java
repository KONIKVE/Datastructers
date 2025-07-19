package org.example.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree<E> {
    private Node<E> root;
    private List<E> traverse;

    public BinaryTree(Node<E> root) {
        this.root = root;
        traverse = new ArrayList<>();
    }

    public BinaryTree(E value) {
        this.root = new Node<E>(value);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    // root - left - right
    public final void preOrder(Node<E> root){
        //base condition
        if(Objects.isNull(root))
            return;
        traverse.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    //  left - root - right
    public final void inOrder(Node<E> root){
        //base condition
        if(Objects.isNull(root))
            return;
        preOrder(root.left);
        traverse.add(root.value);
        preOrder(root.right);
    }

    //  left - right - root
    public final void postOrder(Node<E> root){
        //base condition
        if(Objects.isNull(root))
            return;

        preOrder(root.left);
        preOrder(root.right);
        traverse.add(root.value);

    }

    public final void levelOrder(Node<E> root, List<E> traverse) {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<BinaryTree.Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            traverse.add(node.value);
        }
        System.out.println(traverse);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
        binaryTree.root.left = new Node<Integer>(3);
        binaryTree.root.left.left = new Node<Integer>(2);
        binaryTree.root.left.right = new Node<Integer>(4);
        binaryTree.root.right = new Node<Integer>(8);
        binaryTree.root.right.left = new Node<Integer>(7);
        binaryTree.root.right.right = new Node<Integer>(9);
       // binaryTree.preOrder(binaryTree.root);
       // binaryTree.inOrder(binaryTree.root);
       // binaryTree.postOrder(binaryTree.root);
        binaryTree.levelOrder(root,binaryTree.traverse);

    }

    private static class Node<E>{

        private Node<E> left;
        private E value;
        private Node<E> right;

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", value=" + value +
                    ", right=" + right +
                    '}';
        }


    }

}
