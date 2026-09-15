package Week06;
import java.util.ArrayList;
import java.util.List;
public class LeetCode78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    private static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> powerSet = subsets(nums);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Total Subsets: " + powerSet.size());
        System.out.println("Subsets: " + powerSet);
    }
}
