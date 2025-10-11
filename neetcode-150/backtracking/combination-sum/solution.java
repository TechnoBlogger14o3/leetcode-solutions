/**
 * Time Complexity: O(2^target) - Exponential in worst case
 * Space Complexity: O(target) - Recursion stack depth
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort for better pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return; // Prune invalid path
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // Prune since array is sorted
            }
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

// Alternative approach without sorting
class SolutionNoSort {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Alternative approach using dynamic programming
class SolutionDP {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        
        dp.get(0).add(new ArrayList<>());
        
        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> combination : dp.get(i - candidate)) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(candidate);
                    dp.get(i).add(newCombination);
                }
            }
        }
        
        return dp.get(target);
    }
}

// Alternative approach using iterative method
class SolutionIterative {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Stack<Integer> targetStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        stack.push(new ArrayList<>());
        targetStack.push(target);
        indexStack.push(0);
        
        while (!stack.isEmpty()) {
            List<Integer> current = stack.pop();
            int remainingTarget = targetStack.pop();
            int startIndex = indexStack.pop();
            
            if (remainingTarget == 0) {
                result.add(current);
                continue;
            }
            
            if (remainingTarget < 0) {
                continue;
            }
            
            for (int i = startIndex; i < candidates.length; i++) {
                List<Integer> newCombination = new ArrayList<>(current);
                newCombination.add(candidates[i]);
                stack.push(newCombination);
                targetStack.push(remainingTarget - candidates[i]);
                indexStack.push(i);
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Using memoization
class SolutionMemo {
    private Map<String, List<List<Integer>>> memo = new HashMap<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack(candidates, target, 0);
    }
    
    private List<List<Integer>> backtrack(int[] candidates, int target, int start) {
        String key = target + "," + start;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        if (target < 0) {
            return result;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            
            List<List<Integer>> subResults = backtrack(candidates, target - candidates[i], i);
            for (List<Integer> subResult : subResults) {
                List<Integer> newResult = new ArrayList<>(subResult);
                newResult.add(candidates[i]);
                result.add(newResult);
            }
        }
        
        memo.put(key, result);
        return result;
    }
}
