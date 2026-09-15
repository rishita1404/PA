package Week08;
public class DoublyLinkedList {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    public void insertAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void printForward() {
        System.out.print("Forward: ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
    public void printBackward() {
        System.out.print("Backward: ");
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.val + (curr.prev != null ? " <-> " : ""));
            curr = curr.prev;
        }
        System.out.println();
    }
    public void deleteHead() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }
    public void deleteTail() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(20);
        dll.insertAtHead(10);
        dll.insertAtTail(30);
        dll.insertAtTail(40);
        dll.printForward();
        dll.printBackward();
        System.out.println("Deleting head and tail...");
        dll.deleteHead();
        dll.deleteTail();
        dll.printForward();
    }
}
