import java.util.*;

public class Solution {
    public String lexicographicallySmallestPalindrome(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char oddChar = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] % 2 == 1) {
                if (oddChar != 0) return ""; // More than one odd character
                oddChar = c;
            }
            for (int i = 0; i < count[c - 'a'] / 2; i++) {
                half.append(c);
            }
        }

        String halfStr = half.toString();
        String palindrome = halfStr + (oddChar != 0 ? oddChar : "") + halfStr.reverse().toString();

        if (palindrome.compareTo(target) > 0) {
            return palindrome;
        }

        char[] halfArr = halfStr.toCharArray();
        Arrays.sort(halfArr);
        String nextPalindrome = "";

        while (true) {
            if (!nextPalindrome.isEmpty()) {
                nextPalindrome = new String(halfArr) + (oddChar != 0 ? oddChar : "") + new StringBuilder(new String(halfArr)).reverse().toString();
            } else {
                nextPalindrome = palindrome;
            }

            if (nextPalindrome.compareTo(target) > 0) {
                return nextPalindrome;
            }

            if (!nextPermutation(halfArr)) {
                break;
            }
        }

        return "";
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        char temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}