package linkedlist;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLL() {
        size =0;
    }

    public void insertFirst(int val) {
        Node temp = new Node(val);
        temp.next = head;
        temp.previous = null;
        if(head != null) {
            head.previous = temp;
        }
        head = temp;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        Node temp = new Node(val);
        if(tail == null) {
            insertFirst(val);
            return;
        }
        tail.next = temp;
        temp.previous = tail;
        tail = temp;
        size++;
    }

    public void insertAt(int val, int index) {
        Node temp = new Node(val);
        Node i = head;
        if(tail == null || index == 0) {
            insertFirst(val);
            return;
        }
        if (index >= size) {
            insertLast(val);
            return;
        }
        for (int j = 0; j < index-1; j++) {
            i = i.next;
        }
        temp.next = i.next;
        i.next.previous = temp;
        i.next = temp;
        temp.previous = i;
    }
    public void displayDLL() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
