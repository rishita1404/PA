package Week04;
import java.util.Arrays;
public class MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
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
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = { 2, 3, 1, 2, 4, 3 };
        System.out.printf("Target: %d, Nums: %s -> Min Length: %d%n",
                target1, Arrays.toString(nums1), minSubArrayLen(target1, nums1));
        int target2 = 4;
        int[] nums2 = { 1, 4, 4 };
        System.out.printf("Target: %d, Nums: %s -> Min Length: %d%n",
                target2, Arrays.toString(nums2), minSubArrayLen(target2, nums2));
        int target3 = 11;
        int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.printf("Target: %d, Nums: %s -> Min Length: %d%n",
                target3, Arrays.toString(nums3), minSubArrayLen(target3, nums3));
    }
}
