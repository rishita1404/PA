package Week04;
import java.util.Arrays;
public class LeetCode34_FindFirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0) return result;
        result[0] = findBound(nums, target, true);
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        return result;
    }
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        int bound = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bound;
    }
    public static void main(String[] args) {
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums1), target1, Arrays.toString(searchRange(nums1, target1)));
        int target2 = 6;
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums1), target2, Arrays.toString(searchRange(nums1, target2)));
    }
}
