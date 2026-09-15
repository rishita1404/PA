package Week04;
import java.util.Arrays;
public class LeetCode33_SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        System.out.printf("Array: %s, target = %d -> Index: %d%n",
                Arrays.toString(nums1), target1, search(nums1, target1));
        int target2 = 3;
        System.out.printf("Array: %s, target = %d -> Index: %d%n",
                Arrays.toString(nums1), target2, search(nums1, target2));
    }
}
