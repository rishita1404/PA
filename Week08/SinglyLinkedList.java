package Week08;
public class SinglyLinkedList {
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }
    public void printList() {
        Node curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println(" -> null");
    }
    public int countNodes() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    public boolean search(int target) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) return true;
            curr = curr.next;
        }
        return false;
    }
    public Node findMiddle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reverseIterative() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        head = prev;
    }
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtTail(30);
        sll.insertAtTail(40);
        sll.insertAtTail(50);
        sll.printList();
        System.out.println("Total Nodes: " + sll.countNodes());
        System.out.println("Search for 30: " + sll.search(30));
        System.out.println("Search for 99: " + sll.search(99));
        Node middle = sll.findMiddle();
        System.out.println("Middle Node: " + (middle != null ? middle.data : "null"));
        System.out.println("Reversing list...");
        sll.reverseIterative();
        sll.printList();
    }
}
