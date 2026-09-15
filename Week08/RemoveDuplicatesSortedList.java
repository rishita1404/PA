package Week08;
public class RemoveDuplicatesSortedList {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    public static Node deleteDuplicates(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
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
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        System.out.print("Before removing duplicates: ");
        print(head);
        head = deleteDuplicates(head);
        System.out.print("After removing duplicates: ");
        print(head);
    }
}
