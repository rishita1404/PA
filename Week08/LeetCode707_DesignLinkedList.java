package Week08;
public class LeetCode707_DesignLinkedList {
    static class MyLinkedList {
        static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }
        private Node head;
        private int size;
        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }
        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;
            Node newNode = new Node(val);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                newNode.next = curr.next;
                curr.next = newNode;
            }
            size++;
        }
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            if (index == 0) {
                head = head.next;
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
            size--;
        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println("Get index 1: " + myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println("Get index 1: " + myLinkedList.get(1));
    }
}
