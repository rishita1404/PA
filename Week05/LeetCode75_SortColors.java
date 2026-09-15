package Week05;
import java.util.Arrays;
public class LeetCode75_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] colors = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Original: " + Arrays.toString(colors));
        sortColors(colors);
        System.out.println("Sorted Colors: " + Arrays.toString(colors));
    }
}
