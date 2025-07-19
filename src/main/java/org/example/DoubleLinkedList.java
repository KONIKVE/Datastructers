package org.example;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DoubleLinkedList{");
        Node current = head;
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

    private void addHead(Integer item) {
        Node cur = new Node(item);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            head.prev = cur;
            cur.next = head;
            head = cur;
        }
        size += 1;
    }

    private void addTail(Integer item) {
        Node cur = new Node(item);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }
        size += 1;
    }

    private void addIndex(Integer item, Integer index) {
        if (index < 0 && index > size) {
            return;
        } else if (index == 0) {
            addHead(item);
        } else if (index == size) {
            addTail(item);
        } else {
            Node new_Node = new Node(item);
            Node cur = head;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
                if (i == index) {
                    Node prev = cur.prev;
                    prev.next = new_Node;
                    new_Node.prev = prev;
                    new_Node.next = cur;
                    cur.prev = new_Node;
                }
            }
            size += 1;
        }
    }

    private Integer deleteAtIndex(Integer index) {
        //base condition
        if (index < 0 && index > size - 1) {
            throw new IndexOutOfBoundsException(STR."Invalid Index :\{index}");
        }
        // remove head
        if (index == 0) {
            int temp = head.item;
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
            size -= 1;
            return temp;
        }
        // remove tail
        else if (index == size - 1) {
            int temp = tail.item;
            Node prev = tail.prev;
            tail.prev = null;
            prev.next = null;
            size -= 1;
            return temp;
        } else {
            int temp = 0;
            Node cur = head;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
                if (i == index) {
                    temp = cur.item;
                    Node prev = cur.prev;
                    Node next = cur.next;
                    cur.prev = null;
                    cur.next = null;
                    prev.next = next;
                    next.prev = prev;
                }
            }
            size -= 1;
            return temp;
        }
    }

    // O(logn)
    // Get item at index
    public Integer getItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current;
        // Optimize traversal: start from head or tail depending on index
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.item;
    }


    private Integer get(int index) {
        if (index < 0 && index > size-1) {
            return -1;
        }
        if (index == 0) {
            return head.item;
        }
        if (index == size - 1) {
            return tail.item;
        }
        Node cur = head;
        for (int i = 1; i <= index; i++) {
             cur = cur.next;
            if (index == i) {
                return cur.item;
            }
        }
        return null;
    }


    private Integer getFirst() {
        if(head != null){
            return head.item;
        }
        return -1;
    }

    private Integer getLastElement() {
        if(tail != null){
            return tail.item;
        }
        return -1;
    }

    // Node class for doubly linked list
    private static class Node {
        private Node prev;
        private Integer item;
        private Node next;

        public Node(Integer item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    void reverseList() {
        Node current = head;
        Node temp = null;

        // Traverse the list and swap next and prev pointers for each node
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;  // move to next node (which is prev before swapping)
        }

        // After the loop, temp points to the previous node of null, which is the new head
        if (temp != null) {
            head = temp.prev;
        }
    }


    void reverseDoubleLinkedList() {
        Node current = head;
        Node prec = null;
        Node succ = null;
        while (current != null) {
            succ = current.next;
            prec = current.prev;
            current.prev = succ;
            current.next = prec;
            current = succ;
        }
        head = prec.prev;
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHead(10);
        doubleLinkedList.addHead(20);
        doubleLinkedList.addHead(30);
        doubleLinkedList.addHead(40);
        doubleLinkedList.addHead(50);
        doubleLinkedList.addTail(60);
        doubleLinkedList.addTail(70);
        doubleLinkedList.addTail(80);
        doubleLinkedList.addTail(90);
        doubleLinkedList.addTail(100);
        doubleLinkedList.addIndex(15,1);
        doubleLinkedList.addIndex(25,3);
        System.out.println(doubleLinkedList);

        /*System.out.println(doubleLinkedList.get(0));
        System.out.println(doubleLinkedList.get(1));
        System.out.println(doubleLinkedList.get(2));
        System.out.println(doubleLinkedList.get(3));
        System.out.println(doubleLinkedList.get(4));
        System.out.println(doubleLinkedList.getFirst());
        System.out.println(doubleLinkedList.getLastElement());
        System.out.println(doubleLinkedList.getSize());
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.deleteAtIndex(0));
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.deleteAtIndex(1));
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.deleteAtIndex(2));*/
        doubleLinkedList.reverseDoubleLinkedList();
        System.out.println(doubleLinkedList);
    }
}
