package Week06;
public class LeetCode198_HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prev2 = 0;
        int prev1 = 0;
        for (int num : nums) {
            int current = Math.max(prev1, num + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] houses1 = { 1, 2, 3, 1 };
        System.out.println("Houses: [1, 2, 3, 1] -> Max Money: " + rob(houses1));
        int[] houses2 = { 2, 7, 9, 3, 1 };
        System.out.println("Houses: [2, 7, 9, 3, 1] -> Max Money: " + rob(houses2));
    }
}
