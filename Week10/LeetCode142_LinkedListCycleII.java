package Week10;
public class LeetCode142_LinkedListCycleII {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
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
        ListNode cycleStart = detectCycle(head);
        System.out.println("Cycle begins at node with value: " + (cycleStart != null ? cycleStart.val : "No cycle"));
    }
}
