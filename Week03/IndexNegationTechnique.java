package Week03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IndexNegationTechnique {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int index = val - 1;
            if (nums[index] < 0) {
                duplicates.add(val);
            } else {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicates;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappeared.add(i + 1);
            } else {
                nums[i] = -nums[i];
            }
        }
        return disappeared;
    }
    public static void main(String[] args) {
        int[] arr1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Array for Duplicates: " + Arrays.toString(arr1));
        List<Integer> dups = findDuplicates(arr1);
        System.out.println("Duplicate numbers: " + dups);
        int[] arr2 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("\nArray for Disappeared: " + Arrays.toString(arr2));
        List<Integer> disappeared = findDisappearedNumbers(arr2);
        System.out.println("Disappeared numbers: " + disappeared);
    }
}
