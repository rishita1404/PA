public class SlidingWindowFixedMaxSum {
    public static int maxSubarraySumFixed(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            throw new IllegalArgumentException("Invalid input array or window size k.");
        }
        int currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }
        int maxSum = currentWindowSum;
        for (int i = k; i < arr.length; i++) {
            currentWindowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentWindowSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr1 = { 2, 1, 5, 1, 3, 2 };
        int k1 = 3;
        System.out.printf("Array: [2, 1, 5, 1, 3, 2], K = %d%n", k1);
        System.out.println("Max Subarray Sum: " + maxSubarraySumFixed(arr1, k1));
        int[] arr2 = { 2, 3, 4, 1, 5 };
        int k2 = 2;
        System.out.printf("Array: [2, 3, 4, 1, 5], K = %d%n", k2);
        System.out.println("Max Subarray Sum: " + maxSubarraySumFixed(arr2, k2));
    }
}
