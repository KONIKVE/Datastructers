package org.example;

import java.util.List;
import java.util.Stack;

public class BuildBinarySearchTree {

    private static Node buildBinarySearchTree(List<Integer> preOrder) {
        Stack<Node> stack = new Stack<>();
        Node root = new Node(preOrder.getFirst());
        stack.push(root);
        for (int i = 1; i < preOrder.size(); i++) {
            Node node = new Node(preOrder.get(i));
            if (stack.peek().item > preOrder.get(i)) {

                stack.peek().left = node;
                stack.push(node);
            } else {
                Node pop = null;
                while (!stack.isEmpty() && stack.peek().item < preOrder.get(i)) {
                    pop = stack.pop();
                }
                pop.right = node;
                stack.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        List<Integer> preOrder = List.of(5, 3, 1, 4, 8, 6, 9);
        System.out.println(buildBinarySearchTree(preOrder));
    }

    private static class Node {
        private Integer item;
        private Node left;
        private Node right;

        public Node(Integer item) {
            this.item = item;
        }

        public Integer getItem() {
            return item;
        }

        public void setItem(Integer item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
