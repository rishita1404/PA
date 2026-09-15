package Week06;
import java.util.ArrayList;
import java.util.List;
public class LeetCode17_LetterCombinationsOfAPhoneNumber {
    private static final String[] MAPPING = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return combinations;
        backtrack(0, digits, new StringBuilder(), combinations);
        return combinations;
    }
    private static void backtrack(int index, String digits, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public static void main(String[] args) {
        String digits1 = "23";
        System.out.printf("Digits: '%s' -> Combinations: %s%n", digits1, letterCombinations(digits1));
        String digits2 = "79";
        System.out.printf("Digits: '%s' -> Total Combinations: %d%n", digits2, letterCombinations(digits2).size());
    }
}
