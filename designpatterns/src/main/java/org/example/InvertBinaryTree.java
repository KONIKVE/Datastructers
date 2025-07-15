package org.example;

public class InvertBinaryTree {

    private Node root;


    private static Node invertBinaryTree(Node node) {
        if (node == null)
            return null;
        if (node.left != null && node.right != null) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        return node;
    }

    private static class Node{
       private Integer item;
       private Node left;
       private Node right;

        public Node(Integer item) {
            this.item = item;
        }

        public void setLeft(Node left) {
            this.left = left;
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


    public static void main(String[] args) {
        System.out.println("************ Invert Binary Tree ****************");
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println((root));
        //System.out.println(shiva(root));
        System.out.println(invertBinaryTree(root));
    }

}
