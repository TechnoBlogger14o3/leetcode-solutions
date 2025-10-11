/**
 * Time Complexity: O(n) - Two passes
 * Space Complexity: O(1) - At most 26 characters
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        // Find last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}

// Alternative approach using two pointers
class SolutionTwoPointers {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        
        return result;
    }
}

// Alternative approach using sliding window
class SolutionSlidingWindow {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int windowStart = 0;
        int windowEnd = 0;
        
        for (int i = 0; i < s.length(); i++) {
            windowEnd = Math.max(windowEnd, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == windowEnd) {
                result.add(windowEnd - windowStart + 1);
                windowStart = i + 1;
            }
        }
        
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        int i = 0;
        
        while (i < s.length()) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
            
            i++;
        }
        
        return result;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}
