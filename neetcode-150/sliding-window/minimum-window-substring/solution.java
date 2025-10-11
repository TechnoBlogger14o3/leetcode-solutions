/**
 * Time Complexity: O(m + n) - Where m is length of s, n is length of t
 * Space Complexity: O(m + n) - For frequency maps
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            if (tCount.containsKey(rightChar)) {
                tCount.put(rightChar, tCount.get(rightChar) - 1);
                if (tCount.get(rightChar) >= 0) {
                    counter--;
                }
            }
            
            while (counter == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                if (tCount.containsKey(leftChar)) {
                    tCount.put(leftChar, tCount.get(leftChar) + 1);
                    if (tCount.get(leftChar) > 0) {
                        counter++;
                    }
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

// Alternative approach using arrays for ASCII characters
class SolutionArray {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        
        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            if (tCount[rightChar] > 0) {
                counter--;
            }
            tCount[rightChar]--;
            
            while (counter == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                tCount[leftChar]++;
                if (tCount[leftChar] > 0) {
                    counter++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

// More concise version
class SolutionConcise {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        
        int left = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        
        for (int right = 0; right < s.length(); right++) {
            if (map[s.charAt(right)]-- > 0) counter--;
            
            while (counter == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                if (map[s.charAt(left++)]++ == 0) counter++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
