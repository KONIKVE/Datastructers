package org.example;

public class PriorityQueue {

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.offer(70);
        priorityQueue.offer(80);
        priorityQueue.offer(90);
        priorityQueue.offer(50);
        priorityQueue.offer(40);
        priorityQueue.offer(30);
        priorityQueue.offer(30);

        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        System.out.println(priorityQueue);

    }

}
