import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n) - Where n is the length of the strings
 * Space Complexity: O(1) - At most 26 characters for lowercase English letters
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in string s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Check characters in string t
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        
        return true;
    }
}

// Alternative approach using array (more efficient for lowercase letters)
class SolutionArray {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charCount = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}

// Sorting approach
class SolutionSorting {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        return Arrays.equals(sArray, tArray);
    }
}
