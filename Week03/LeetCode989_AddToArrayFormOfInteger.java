package Week03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LeetCode989_AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = k;
        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num[i];
                i--;
            }
            result.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        int[] num1 = { 1, 2, 0, 0 };
        int k1 = 34;
        System.out.printf("num = [1,2,0,0], k = 34 -> %s%n", addToArrayForm(num1, k1));
        int[] num2 = { 2, 7, 4 };
        int k2 = 181;
        System.out.printf("num = [2,7,4], k = 181 -> %s%n", addToArrayForm(num2, k2));
        int[] num3 = { 2, 1, 5 };
        int k3 = 806;
        System.out.printf("num = [2,1,5], k = 806 -> %s%n", addToArrayForm(num3, k3));
    }
}
