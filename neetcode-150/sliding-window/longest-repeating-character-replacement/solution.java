/**
 * Time Complexity: O(n) - Single pass through the string
 * Space Complexity: O(1) - At most 26 characters
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxCount = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            // Update maxCount to track most frequent character
            maxCount = Math.max(maxCount, charCount.get(rightChar));
            
            // If window size - maxCount > k, contract window
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// Alternative approach using array for ASCII characters
class SolutionArray {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] charCount = new int[26];
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar - 'A']++;
            
            maxCount = Math.max(maxCount, charCount[rightChar - 'A']);
            
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// More concise version
class SolutionConcise {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left++) - 'A']--;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
