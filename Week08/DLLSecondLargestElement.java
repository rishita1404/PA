package Week08;
public class DLLSecondLargestElement {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }
    public static int findSecondLargest(Node head) {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("List must have at least two nodes.");
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        Node curr = head;
        while (curr != null) {
            if (curr.val > max1) {
                max2 = max1;
                max1 = curr.val;
            } else if (curr.val > max2 && curr.val != max1) {
                max2 = curr.val;
            }
            curr = curr.next;
        }
        if (max2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No distinct second largest element found (all values equal).");
        }
        return max2;
    }
    public static void main(String[] args) {
        Node head = new Node(14);
        Node n2 = new Node(29);
        Node n3 = new Node(8);
        Node n4 = new Node(45);
        Node n5 = new Node(37);
        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        System.out.println("DLL values: 14 <-> 29 <-> 8 <-> 45 <-> 37");
        System.out.println("Second Largest Element: " + findSecondLargest(head));
    }
}
