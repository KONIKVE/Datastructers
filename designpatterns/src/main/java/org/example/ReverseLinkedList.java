package org.example;

public class ReverseLinkedList {
   private Node head;
    private Node tail;
   private int size;

    public ReverseLinkedList() {
        super();
    }

    // three pointer technique
    private void reverseLinkedList(){
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    private void addElement(Integer index, Integer ele) {
        if (index < 0 && index > size) {
            return;
        }
        Node cur = new Node(ele);
        if (index == 0) {
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head = cur;
            }
        } else if (index == size) {
            tail.next = cur;
            tail = cur;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
                if (i == index-1) {
                    Node next = current.next;
                    current.next = cur;
                    cur.next = next;
                }
            }
        }
        size += 1;
    }

    private void reverse() {
        Node cur = head;
        Node suc = null;
        Node prev = null;
        while (cur != null) {
            suc = cur.next;
            cur.next = prev;
            prev = cur;
            cur = suc;
        }
        head = prev;
        System.out.println(head);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{");
        ReverseLinkedList.Node current = head;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("}");
        return sb.toString();
    }

    private static class Node {
        private Integer item;
        private Node next;

        public Node(Integer item) {
            this.item = item;
        }

        public Integer getItem() {
            return item;
        }

        public void setItem(Integer item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.addElement(0,10);
        obj.addElement(1,20);
        obj.addElement(2,30);
        obj.addElement(3,40);
        obj.addElement(4,50);
        obj.addElement(4,45);
        System.out.println(obj);
        obj.reverseLinkedList();
        System.out.println(obj);
    }


}
