import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String smallestPalindromic(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char middle = '\0';

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (middle == '\0' || i + 'a' < middle) {
                    middle = (char) (i + 'a');
                }
            }
            half.append(String.valueOf((char) (i + 'a')).repeat(count[i] / 2));
        }

        StringBuilder result = new StringBuilder(half);
        if (middle != '\0') {
            result.append(middle);
        }
        result.append(half.reverse());

        return result.toString();
    }
}