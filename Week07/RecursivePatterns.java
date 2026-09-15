package Week07;
import java.util.ArrayList;
import java.util.List;
public class RecursivePatterns {
    public static int fibStandard(int n) {
        if (n <= 1) return n;
        return fibStandard(n - 1) + fibStandard(n - 2);
    }
    public static int fibTail(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibTail(n - 1, b, a + b);
    }
    public static List<String> getAllSubstrings(String str) {
        List<String> substrings = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }
    public static List<String> getAllSubsequences(String str) {
        List<String> subsequences = new ArrayList<>();
        generateSubsequences(0, str, new StringBuilder(), subsequences);
        return subsequences;
    }
    private static void generateSubsequences(int index, String str, StringBuilder current, List<String> result) {
        if (index == str.length()) {
            result.add(current.toString());
            return;
        }
        current.append(str.charAt(index));
        generateSubsequences(index + 1, str, current, result);
        current.deleteCharAt(current.length() - 1);
        generateSubsequences(index + 1, str, current, result);
    }
    public static void print1ToNHeadRecursion(int n) {
        if (n == 0) return;
        print1ToNHeadRecursion(n - 1);
        System.out.print(n + " ");
    }
    public static void printNDownTo1TailRecursion(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNDownTo1TailRecursion(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("=== 1. Fibonacci Comparison ===");
        int n = 7;
        System.out.printf("Standard Fib(%d): %d%n", n, fibStandard(n));
        System.out.printf("Tail-Recursive Fib(%d): %d%n", n, fibTail(n, 0, 1));
        System.out.println("\n=== 2. Substrings vs. Subsequences for 'abc' ===");
        String s = "abc";
        System.out.println("Substrings (contiguous): " + getAllSubstrings(s));
        System.out.println("Subsequences (order preserved): " + getAllSubsequences(s));
        System.out.println("\n=== 3. Head vs. Tail Recursion ===");
        System.out.print("Head Recursion (1 to 5): ");
        print1ToNHeadRecursion(5);
        System.out.println();
        System.out.print("Tail Recursion (5 down to 1): ");
        printNDownTo1TailRecursion(5);
        System.out.println();
    }
}
