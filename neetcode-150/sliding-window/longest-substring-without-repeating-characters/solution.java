/**
 * Time Complexity: O(n) - Each character visited at most twice
 * Space Complexity: O(min(m,n)) - Where m is charset size
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            // Contract window if duplicates found
            while (charCount.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// Alternative approach using Set
class SolutionSet {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            // Contract window if duplicate found
            while (charSet.contains(rightChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            charSet.add(rightChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// Optimized version with character position tracking
class SolutionOptimized {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            if (charIndex.containsKey(rightChar) && charIndex.get(rightChar) >= left) {
                left = charIndex.get(rightChar) + 1;
            }
            
            charIndex.put(rightChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
