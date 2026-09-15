package Week05;
import java.util.Arrays;
public class LeetCode912_SortAnArray {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }
    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }
    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int p = left; p <= right; p++) {
            nums[p] = temp[p];
        }
    }
    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        System.out.println("Input: " + Arrays.toString(nums));
        sortArray(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }
}
