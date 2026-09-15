package Week08;
public class ReverseNodesInKGroup {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;
        while (true) {
            Node kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;
            Node groupNext = kth.next;
            Node prev = groupNext;
            Node curr = groupPrev.next;
            while (curr != groupNext) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            Node temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }
    public static void print(Node head) {
        Node c = head;
        while (c != null) {
            System.out.print(c.val + (c.next != null ? " -> " : ""));
            c = c.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.print("Original List: ");
        print(head);
        head = reverseKGroup(head, 2);
        System.out.print("Reversed in groups of 2: ");
        print(head);
    }
}
