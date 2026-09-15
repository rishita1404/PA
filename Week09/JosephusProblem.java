package Week09;
public class JosephusProblem {
    static class Node {
        int id;
        Node next;
        Node(int id) { this.id = id; }
    }
    public static int solveUsingCLL(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n and k must be positive integers.");
        }
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            Node curr = new Node(i);
            prev.next = curr;
            prev = curr;
        }
        prev.next = head;
        Node curr = head;
        Node beforeCurr = prev;
        while (curr.next != curr) {
            for (int count = 1; count < k; count++) {
                beforeCurr = curr;
                curr = curr.next;
            }
            System.out.printf("Person %d is eliminated%n", curr.id);
            beforeCurr.next = curr.next;
            curr = beforeCurr.next;
        }
        return curr.id;
    }
    public static int solveFormula(int n, int k) {
        int survivor = 0;
        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        return survivor + 1;
    }
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        System.out.printf("Josephus Problem (n = %d, k = %d):%n", n, k);
        int survivorCLL = solveUsingCLL(n, k);
        int survivorMath = solveFormula(n, k);
        System.out.printf("Survivor (CLL simulation): %d%n", survivorCLL);
        System.out.printf("Survivor (Math formula):   %d%n", survivorMath);
    }
}
