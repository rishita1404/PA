package Week03;
import java.util.Arrays;
public class FixedSlidingWindowMaxSum {
    public static int calculateMaxSubarraySum(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            throw new IllegalArgumentException("Invalid array or window size k.");
        }
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = { 100, 200, 300, 400 };
        int k = 2;
        System.out.printf("Array: %s, k = %d%n", Arrays.toString(arr), k);
        System.out.println("Max Subarray Sum: " + calculateMaxSubarraySum(arr, k));
        int[] arr2 = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int k2 = 4;
        System.out.printf("Array: %s, k = %d%n", Arrays.toString(arr2), k2);
        System.out.println("Max Subarray Sum: " + calculateMaxSubarraySum(arr2, k2));
    }
}
