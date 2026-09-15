package Week10;
public class LeetCode141_LinkedListCycle {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println("Has Cycle (with loop): " + hasCycle(head));
        ListNode normal = new ListNode(1);
        normal.next = new ListNode(2);
        System.out.println("Has Cycle (linear): " + hasCycle(normal));
    }
}
