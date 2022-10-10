package linkedlist;

public class MergeSortLL {
    private ListNode head;

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                newTail.val = left.val;
                left = left.next;
                newTail = newTail.next;
            } else {
                newTail.val = right.val;
                right = right.next;
                newTail = newTail.next;
            }
        }
        if(left != null) newTail = left;
        else newTail = right;
        return newHead;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
