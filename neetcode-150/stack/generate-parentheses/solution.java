/**
 * Time Complexity: O(4^n / √n) - Catalan number
 * Space Complexity: O(n) - Recursion depth
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}

// Alternative approach using StringBuilder for better performance
class SolutionStringBuilder {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(result, current, 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }
        
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }
        
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

// Iterative approach using queue
class SolutionIterative {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int open = countChar(current, '(');
            int close = countChar(current, ')');
            
            if (open == n && close == n) {
                result.add(current);
            } else {
                if (open < n) {
                    queue.offer(current + "(");
                }
                if (close < open) {
                    queue.offer(current + ")");
                }
            }
        }
        
        return result;
    }
    
    private int countChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }
}

// More concise version
class SolutionConcise {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    
    private void generate(List<String> result, String s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        
        if (open < n) generate(result, s + "(", open + 1, close, n);
        if (close < open) generate(result, s + ")", open, close + 1, n);
    }
}
