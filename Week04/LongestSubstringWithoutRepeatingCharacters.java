package Week04;
import java.util.HashSet;
import java.util.Set;
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> windowSet = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (windowSet.contains(c)) {
                windowSet.remove(s.charAt(left));
                left++;
            }
            windowSet.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String[] testCases = { "abcabcbb", "bbbbb", "pwwkew", "" };
        for (String s : testCases) {
            System.out.printf("String: '%s' -> Longest Non-Repeating Substring Length: %d%n",
                    s, lengthOfLongestSubstring(s));
        }
    }
}
