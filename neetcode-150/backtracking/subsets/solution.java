/**
 * Time Complexity: O(2^n) - 2^n possible subsets
 * Space Complexity: O(n) - Recursion stack depth
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));
        
        // Try adding each remaining element
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

// Alternative approach using iterative method
class SolutionIterative {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Add empty subset
        
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        
        return result;
    }
}

// Alternative approach using bit manipulation
class SolutionBitManipulation {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
}

// Alternative approach using recursion without backtracking
class SolutionRecursive {
    public List<List<Integer>> subsets(int[] nums) {
        return generateSubsets(nums, 0);
    }
    
    private List<List<Integer>> generateSubsets(int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        
        List<List<Integer>> result = generateSubsets(nums, index + 1);
        int size = result.size();
        
        for (int i = 0; i < size; i++) {
            List<Integer> newSubset = new ArrayList<>(result.get(i));
            newSubset.add(nums[index]);
            result.add(newSubset);
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Using StringBuilder for path tracking
class SolutionStringBuilder {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, StringBuilder path, List<List<Integer>> result) {
        List<Integer> current = new ArrayList<>();
        String[] parts = path.toString().split(",");
        for (String part : parts) {
            if (!part.isEmpty()) {
                current.add(Integer.parseInt(part));
            }
        }
        result.add(current);
        
        for (int i = start; i < nums.length; i++) {
            if (path.length() > 0) path.append(",");
            path.append(nums[i]);
            backtrack(nums, i + 1, path, result);
            // Remove last added element
            int lastComma = path.lastIndexOf(",");
            if (lastComma == -1) {
                path.setLength(0);
            } else {
                path.setLength(lastComma);
            }
        }
    }
}
