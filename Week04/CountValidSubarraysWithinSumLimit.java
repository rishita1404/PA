package Week04;
import java.util.Arrays;
public class CountValidSubarraysWithinSumLimit {
    public static long countSubarraysWithSumAtMostK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        int left = 0;
        int currentSum = 0;
        long count = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 6 };
        int k1 = 10;
        System.out.printf("Array: %s, K = %d -> Count of Subarrays with sum <= %d: %d%n",
                Arrays.toString(nums1), k1, k1, countSubarraysWithSumAtMostK(nums1, k1));
        int[] nums2 = { 1, 11, 2, 3, 15 };
        int k2 = 10;
        System.out.printf("Array: %s, K = %d -> Count of Subarrays with sum <= %d: %d%n",
                Arrays.toString(nums2), k2, k2, countSubarraysWithSumAtMostK(nums2, k2));
    }
}
