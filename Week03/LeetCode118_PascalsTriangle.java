package Week03;
import java.util.ArrayList;
import java.util.List;
public class LeetCode118_PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
