package Week11;
import java.util.Arrays;
import java.util.Stack;
public class DailyTemperaturesLC739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int pday = st.pop();
                ans[pday] = i - pday;
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temps1)));
        int[] temps2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(dailyTemperatures(temps2)));
        int[] temps3 = {30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures(temps3)));
    }
}