package Week08;
public class PalindromeLinkedList {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalfHead = reverse(slow.next);
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean palindrome = true;
        while (palindrome && p2 != null) {
            if (p1.val != p2.val) {
                palindrome = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = reverse(secondHalfHead);
        return palindrome;
    }
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        System.out.println("List 1 -> 2 -> 2 -> 1 is Palindrome? " + isPalindrome(head1));
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        System.out.println("List 1 -> 2 -> 3 is Palindrome? " + isPalindrome(head2));
    }
}
