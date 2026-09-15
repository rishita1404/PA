package Week08;
public class DLLInsertAfterKey {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }
    public static boolean insertAfterKey(Node head, int key, int newVal) {
        Node curr = head;
        while (curr != null && curr.val != key) {
            curr = curr.next;
        }
        if (curr == null) {
            return false;
        }
        Node newNode = new Node(newVal);
        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return true;
    }
    public static void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(40);
        head.next.next.prev = head.next;
        System.out.print("Original DLL: ");
        printDLL(head);
        System.out.println("Inserting 30 after key 20...");
        insertAfterKey(head, 20, 30);
        System.out.print("Updated DLL: ");
        printDLL(head);
    }
}
