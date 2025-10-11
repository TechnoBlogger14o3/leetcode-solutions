/**
 * Time Complexity: O(2^n) - Exponential in worst case
 * Space Complexity: O(target) - Recursion stack depth
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to group duplicates
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
            // Skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] > target) {
                break; // Prune since array is sorted
            }
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

// Alternative approach using Set
class SolutionSet {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, Set<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Alternative approach using frequency map
class SolutionFrequency {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : candidates) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(freq, target, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(Map<Integer, Integer> freq, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int num : freq.keySet()) {
            if (freq.get(num) > 0 && num <= target) {
                current.add(num);
                freq.put(num, freq.get(num) - 1);
                backtrack(freq, target - num, current, result);
                freq.put(num, freq.get(num) + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}

// Alternative approach using iterative method
class SolutionIterative {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                
                if (candidates[i] > remainingTarget) {
                    break;
                }
                
                List<Integer> newCombination = new ArrayList<>(current);
                newCombination.add(candidates[i]);
                stack.push(newCombination);
                targetStack.push(remainingTarget - candidates[i]);
                indexStack.push(i + 1);
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Using memoization
class SolutionMemo {
    private Map<String, List<List<Integer>>> memo = new HashMap<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] > target) {
                break;
            }
            
            List<List<Integer>> subResults = backtrack(candidates, target - candidates[i], i + 1);
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
