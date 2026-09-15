package Week08;
public class NthNodeFromEnd {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    public static Node findNthFromEnd(Node head, int n) {
        if (head == null || n <= 0) return null;
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        int n = 2;
        Node target = findNthFromEnd(head, n);
        System.out.println("List: 10 -> 20 -> 30 -> 40 -> 50");
        System.out.printf("%d-th node from end: %d%n", n, target != null ? target.val : -1);
    }
}
