package linkedlist;
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst (int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if(tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast (int value) {
        Node newNode = new Node(value);
        if(tail == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size +=1;
    }

    public void insertAt(int pos, int val) {
        Node node = new Node(val);
        Node temp = head;
        if(tail == null || pos == 1 || pos == 0) {
            insertFirst(val);
            return;
        }
        if(pos > size) {
            insertLast(val);
            return;
        }
        pos -= 2;
        while(pos > 0) {
            temp = temp.next;
            pos--;
        }
        node.next = temp.next;
        temp.next = node;
        size += 1;
    }
    //insert a node at a position using recursion
    public void insertAtPosUsingRec(int val, int pos) {
        if(pos == 0 || head == null) {
            insertFirst(val);
            return;
        }
        helper(val, pos-1, head);
    }

    private void helper(int val, int pos, Node temp) {

        if(pos == 0) {
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            size++;
            return;
        }
        helper(val, pos -1, temp.next);
    }

    //this function will delete the first node
    public int deleteFirst () {
        int val = head.value;
        head = head.next;
        size -= 1;
        return val;
    }
    //this function will delete the last node
    public int deleteLast () {
        Node i = head;
        while(i.next.next != null) {
            i = i.next;
        }
        int val = i.next.value;
        i.next = null;
        tail = i;
        size -= 1;
        return val;
    }
    //this function will delete the node on the given position
    public int deletePosition(int Position) {
        Node temp = head;
        if(Position == 1) {
            head = head.next;
        }
        int count = 1;
        while(count < Position-1) {
            temp = temp.next;
            count ++;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size -= 1;
        return val;
    }
    //this function will delete the nodes with the given value
    public void deleteValues(int val) {
        Node i = head;
        Node j = head;
        while(i != null) {
            if(i.value == val) {
                if(i == head) {
                    head = head.next;
                    i = head;
                    j = head;
                } else {
                    j.next = i.next;
                    i = i.next;
                }
            } else {
                j = i;
                i = i.next;
            }
        }
    }

    public void displayLL () {
        Node i = head;
        while(i != null) {
            System.out.print(i.value + " -> ");
            i = i.next;
        }
        System.out.println("END");
    }

    //sort the ll using bubble sort algorithm
    public void sortLL () {
        Node temp = head;

        int s =0;
        while(temp != null){
            s += 1;
            temp = temp.next;
        }
        if(s <= 1) {
            return;
        }
        for(int i=0; i< s -1; i++) {
            Node p = head;
            for(int j=0; j< s-i-1; j++) {
                if(p.value > p.next.value) {
                    int t = p.value;
                    p.value = p.next.value;
                    p.next.value = t;
                }
                p=p.next;
            }
        }
    }
    public void reverseLL() {
        if(size < 2) {
            return;
        }
        Node one = null;
        Node two = head;
        Node three = head.next;
        tail = head;
        while(two != null) {
            two.next = one;
            one = two;
            two = three;
            if( three != null) three = three.next;
        }
        head = one;
    }
    public void reverseLLRec() {
        if(head == null || head.next == null) return;
        recursionReverse(null,head,head.next);
    }

    private void recursionReverse(Node i, Node j,Node k) {
        if( k == null) {
            j.next = i;
            head = j;
            return;
        }
        j.next = i;
        recursionReverse(j,k,k.next);
    }
    public void reverseKGroup(int k) {
        if(k==1 || head == null) return;
        Node one = null;
        Node two = head;
        Node three = head.next;
        while(true) {
            int flag = 0;
            Node temp = two;
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if(flag == 1) break;
            Node last = one;
            Node newEnd = two;
            for (int i = 0; two != null && i < k; i++) {
                two.next = one;
                one = two;
                two = three;
                if (three != null) three = three.next;
            }
            if (last != null) {
                last.next = one;
            } else {
                head = one;
            }
            newEnd.next = two;
            one = newEnd;
        }
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
