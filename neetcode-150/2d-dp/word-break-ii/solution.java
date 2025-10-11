/**
 * Time Complexity: O(2^n) - Exponential in worst case
 * Space Complexity: O(2^n) - Store all sentences
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        
        wordBreakHelper(s, wordSet, 0, current, result);
        return result;
    }
    
    private void wordBreakHelper(String s, Set<String> wordSet, int start, 
                                List<String> current, List<String> result) {
        if (start == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                current.add(word);
                wordBreakHelper(s, wordSet, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}

// Alternative approach using DP + backtracking
class SolutionDPBacktracking {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        // Check if string can be segmented
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        if (!dp[s.length()]) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        wordBreakHelper(s, wordSet, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void wordBreakHelper(String s, Set<String> wordSet, int start, 
                                List<String> current, List<String> result) {
        if (start == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                current.add(word);
                wordBreakHelper(s, wordSet, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}

// Alternative approach using memoization
class SolutionMemoization {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, 0, memo);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> wordSet, int start, 
                                        Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<String> result = new ArrayList<>();
        
        if (start == s.length()) {
            result.add("");
            return result;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> subResults = wordBreakHelper(s, wordSet, end, memo);
                for (String subResult : subResults) {
                    result.add(word + (subResult.isEmpty() ? "" : " " + subResult));
                }
            }
        }
        
        memo.put(start, result);
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        wordBreakHelper(s, wordSet, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void wordBreakHelper(String s, Set<String> wordSet, int start, 
                                List<String> current, List<String> result) {
        if (start == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                current.add(word);
                wordBreakHelper(s, wordSet, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
