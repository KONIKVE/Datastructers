package org.example;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.head = linkedList.add();
        System.out.println(linkedList.head);
    }

    public void add(E item) {


    }


    public void delete(Node<E> node){


    }


    public Node<E> search(E item){

    return null;

    }



    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}
