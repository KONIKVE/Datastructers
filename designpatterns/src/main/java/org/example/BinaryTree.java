package org.example;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {


    private static Node buildBinaryTreeUsingRecursion(Queue<Integer> preOrder, List<Integer> inOrder) {
        //base condition
        if(preOrder.size()==1)
           return new Node(preOrder.peek());

        if(inOrder.size()==0)
            return null;

        Integer root = preOrder.poll();
        Node node = new Node(root);

        node.left = buildBinaryTreeUsingRecursion(preOrder,inOrder.subList(0,inOrder.indexOf(root)));
        node.right = buildBinaryTreeUsingRecursion(preOrder,inOrder.subList(inOrder.indexOf(root)+1,inOrder.size()));

        return node;
    }

    public static void main(String[] args) {
        System.out.println("***********************");
        Queue<Integer> preOrderQueue = new ArrayDeque<>();
        preOrderQueue.offer(1);
        preOrderQueue.offer(2);
        preOrderQueue.offer(4);
        preOrderQueue.offer(8);
        preOrderQueue.offer(9);
        preOrderQueue.offer(5);
        preOrderQueue.offer(10);
        preOrderQueue.offer(11);
        preOrderQueue.offer(3);
        preOrderQueue.offer(6);
        preOrderQueue.offer(7);
        List<Integer> inOrder = List.of(8, 4, 9, 2, 10, 5, 11, 1, 6, 3, 7);
        System.out.println((buildBinaryTreeUsingHash(preOrderQueue, inOrder)));
    }

    private static Node buildBinaryTreeUsingHash(Queue<Integer> preOrderQueue, List<Integer> inOrder){
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            hashMap.put(i,inOrder.get(i));
        }
        return buildBinaryTreeUsingHashHelper(preOrderQueue,inOrder,0,inOrder.size(),hashMap);
    }

    private static Node buildBinaryTreeUsingHashHelper(Queue<Integer> preOrderQueue, List<Integer> inOrder, int left, int right, Map<Integer,Integer> hashMap){
        if(left >= right || preOrderQueue.isEmpty()){
            return null;
        }
        Integer root = preOrderQueue.poll();
        Node node = new Node(root);
        Integer index = hashMap.get(root);
        node.left = buildBinaryTreeUsingHashHelper(preOrderQueue,inOrder,left,index!=null?index:0,hashMap);
        node.right = buildBinaryTreeUsingHashHelper(preOrderQueue,inOrder,index!=null?index+1:0,right,hashMap);
        return node;
    }

    private static class Node {
        private Integer root;
        private Node left;
        private Node right;
        public Node(Integer root) {
            this.root = root;
        }
        public void setRoot(Integer root) {
            this.root = root;
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
                    "root=" + root +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
