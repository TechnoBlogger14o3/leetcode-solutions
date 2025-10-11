/**
 * Time Complexity: O(n) - Where n is length of s2
 * Space Complexity: O(1) - At most 26 characters
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Initialize frequency maps
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check if initial window matches
        if (Arrays.equals(s1Count, s2Count)) return true;
        
        // Slide window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Remove leftmost character
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            
            // Add rightmost character
            s2Count[s2.charAt(i) - 'a']++;
            
            // Check if frequencies match
            if (Arrays.equals(s1Count, s2Count)) return true;
        }
        
        return false;
    }
}

// Alternative approach using HashMap
class SolutionHashMap {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();
        
        // Initialize s1 frequency map
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        
        // Initialize window
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }
        
        if (s1Count.equals(s2Count)) return true;
        
        // Slide window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Remove leftmost character
            char leftChar = s2.charAt(i - s1.length());
            s2Count.put(leftChar, s2Count.get(leftChar) - 1);
            if (s2Count.get(leftChar) == 0) {
                s2Count.remove(leftChar);
            }
            
            // Add rightmost character
            char rightChar = s2.charAt(i);
            s2Count.put(rightChar, s2Count.getOrDefault(rightChar, 0) + 1);
            
            if (s1Count.equals(s2Count)) return true;
        }
        
        return false;
    }
}

// More concise version
class SolutionConcise {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        
        int left = 0, right = 0;
        while (right < s2.length()) {
            count[s2.charAt(right) - 'a']--;
            
            if (right - left + 1 == s1.length()) {
                if (Arrays.stream(count).allMatch(x -> x == 0)) return true;
                count[s2.charAt(left) - 'a']++;
                left++;
            }
            right++;
        }
        
        return false;
    }
}
