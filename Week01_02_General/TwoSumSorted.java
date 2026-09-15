import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TwoSumSorted {
    public static int[] findSinglePairIndices(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{ left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{ -1, -1 };
    }
    public static List<List<Integer>> findAllUniquePairs(int[] numbers, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                pairs.add(Arrays.asList(numbers[left], numbers[right]));
                while (left < right && numbers[left] == numbers[left + 1]) left++;
                while (left < right && numbers[right] == numbers[right - 1]) right--;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4, 5, 6, 7, 11, 15 };
        int target = 8;
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        int[] singlePair = findSinglePairIndices(nums, target);
        System.out.println("First Pair 1-based Indices: " + Arrays.toString(singlePair));
        List<List<Integer>> allPairs = findAllUniquePairs(nums, target);
        System.out.println("All Unique Pairs summing to " + target + ": " + allPairs);
    }
}
