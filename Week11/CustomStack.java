package Week11;
public class CustomStack {
    int[] arr;
    int top;
    public CustomStack(int size) {
        arr = new int[size];
        top = -1;
    }
    public void push(int value) {
        if (top == arr.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = value;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        stack.display();
    }
}