package Week03;
public class MaxVowelsInSubstring {
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static int maxVowels(String s, int k) {
        if (s == null || k <= 0 || s.length() < k) {
            return 0;
        }
        int currentVowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
        }
        int maxVowels = currentVowelCount;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
            if (isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }
            maxVowels = Math.max(maxVowels, currentVowelCount);
            if (maxVowels == k) return k;
        }
        return maxVowels;
    }
    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.printf("String: '%s', k = %d -> Max Vowels: %d%n", s1, k1, maxVowels(s1, k1));
        String s2 = "aeiou";
        int k2 = 2;
        System.out.printf("String: '%s', k = %d -> Max Vowels: %d%n", s2, k2, maxVowels(s2, k2));
        String s3 = "leetcode";
        int k3 = 3;
        System.out.printf("String: '%s', k = %d -> Max Vowels: %d%n", s3, k3, maxVowels(s3, k3));
    }
}
