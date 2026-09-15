package Week09;
public class CircularLinkedList {
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public int countNodes() {
        if (head == null) return 0;
        int count = 0;
        Node curr = head;
        do {
            count++;
            curr = curr.next;
        } while (curr != head);
        return count;
    }
    public boolean search(int target) {
        if (head == null) return false;
        Node curr = head;
        do {
            if (curr.data == target) return true;
            curr = curr.next;
        } while (curr != head);
        return false;
    }
    public boolean deleteNode(int key) {
        if (head == null) return false;
        Node curr = head;
        Node prev = null;
        if (head.data == key && head.next == head) {
            head = tail = null;
            return true;
        }
        if (head.data == key) {
            head = head.next;
            tail.next = head;
            return true;
        }
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                return true;
            }
        } while (curr != head);
        return false;
    }
    public int findMax() {
        if (head == null) {
            throw new IllegalStateException("Circular list is empty.");
        }
        int max = head.data;
        Node curr = head.next;
        while (curr != head) {
            if (curr.data > max) {
                max = curr.data;
            }
            curr = curr.next;
        }
        return max;
    }
    public Node findMiddle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void printReverse() {
        System.out.print("Reverse Print: ");
        if (head != null) {
            printReverseHelper(head, head);
        }
        System.out.println();
    }
    private void printReverseHelper(Node curr, Node start) {
        if (curr.next != start) {
            printReverseHelper(curr.next, start);
        }
        System.out.print(curr.data + " ");
    }
    public void display() {
        if (head == null) {
            System.out.println("Circular List is empty.");
            return;
        }
        System.out.print("CLL: ");
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(head: " + head.data + ")");
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        System.out.println("=== Testing Circular Linked List Operations ===");
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtBeginning(5);
        cll.insertAtEnd(40);
        cll.display();
        System.out.println("Total Nodes: " + cll.countNodes());
        System.out.println("Search for 20: " + cll.search(20));
        System.out.println("Search for 99: " + cll.search(99));
        System.out.println("Maximum Element: " + cll.findMax());
        Node mid = cll.findMiddle();
        System.out.println("Middle Element: " + (mid != null ? mid.data : "null"));
        cll.printReverse();
        System.out.println("Deleting node 20...");
        cll.deleteNode(20);
        cll.display();
        System.out.println("Deleting head node 5...");
        cll.deleteNode(5);
        cll.display();
    }
}
