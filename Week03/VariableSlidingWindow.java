package Week03;
import java.util.Arrays;
public class VariableSlidingWindow {
    public static int longestSubarraySumAtMostK(int[] arr, int k) {
        int left = 0;
        int currentSum = 0;
        int maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            while (currentSum > k && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 1, 0, 1, 1, 0 };
        int k1 = 4;
        System.out.printf("Array: %s, K = %d%n", Arrays.toString(arr1), k1);
        System.out.println("Longest Subarray with Sum <= 4 length: " + longestSubarraySumAtMostK(arr1, k1));
        int[] arr2 = { 2, 3, 1, 2, 4, 3 };
        int target2 = 7;
        System.out.printf("Array: %s, Target = %d%n", Arrays.toString(arr2), target2);
        System.out.println("Minimum Subarray with Sum >= 7 length: " + minSubArrayLen(target2, arr2));
    }
}
