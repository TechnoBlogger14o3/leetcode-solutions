/**
 * Time Complexity: O(2^n) - Exponential in worst case
 * Space Complexity: O(2^n) - Store all partitions
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        
        partitionHelper(s, 0, current, result);
        return result;
    }
    
    private void partitionHelper(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                current.add(substring);
                partitionHelper(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Alternative approach using DP + backtracking
class SolutionDPBacktracking {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Precompute palindrome information
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result, dp);
        return result;
    }
    
    private void partitionHelper(String s, int start, List<String> current, 
                               List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                current.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, current, result, dp);
                current.remove(current.size() - 1);
            }
        }
    }
}

// Alternative approach using memoization
class SolutionMemoization {
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return partitionHelper(s, 0, memo);
    }
    
    private List<List<String>> partitionHelper(String s, int start, Map<Integer, List<List<String>>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        if (start == s.length()) {
            result.add(new ArrayList<>());
            return result;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                List<List<String>> subResults = partitionHelper(s, end, memo);
                for (List<String> subResult : subResults) {
                    List<String> newResult = new ArrayList<>();
                    newResult.add(substring);
                    newResult.addAll(subResult);
                    result.add(newResult);
                }
            }
        }
        
        memo.put(start, result);
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        
        while (!queue.isEmpty()) {
            List<String> current = queue.poll();
            int start = current.stream().mapToInt(String::length).sum();
            
            if (start == s.length()) {
                result.add(current);
                continue;
            }
            
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (isPalindrome(substring)) {
                    List<String> newPartition = new ArrayList<>(current);
                    newPartition.add(substring);
                    queue.offer(newPartition);
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// More concise version
class SolutionConcise {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void partitionHelper(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                current.add(substring);
                partitionHelper(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
