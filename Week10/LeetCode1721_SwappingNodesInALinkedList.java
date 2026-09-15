package Week10;
public class LeetCode1721_SwappingNodesInALinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode second = head;
        ListNode fast = first;
        while (fast.next != null) {
            second = second.next;
            fast = fast.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Original: ");
        print(head);
        head = swapNodes(head, 2);
        System.out.print("Swapped 2nd from front and 2nd from end: ");
        print(head);
    }
}
