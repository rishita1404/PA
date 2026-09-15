package Week08;
public class DeleteMiddleNode {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        }
        return head;
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
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(6);
        System.out.print("Original List: ");
        print(head);
        head = deleteMiddle(head);
        System.out.print("After deleting middle node (7): ");
        print(head);
    }
}
