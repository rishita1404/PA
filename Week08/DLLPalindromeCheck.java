package Week08;
public class DLLPalindromeCheck {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node left = head;
        Node right = tail;
        while (left != right && left.prev != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }
    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        h1.next = n2; n2.prev = h1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        System.out.println("1 <-> 2 <-> 3 <-> 2 <-> 1 is Palindrome? " + isPalindrome(h1));
        Node h2 = new Node(1);
        Node m2 = new Node(2);
        Node m3 = new Node(3);
        h2.next = m2; m2.prev = h2;
        m2.next = m3; m3.prev = m2;
        System.out.println("1 <-> 2 <-> 3 is Palindrome? " + isPalindrome(h2));
    }
}
