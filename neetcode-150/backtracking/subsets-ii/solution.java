/**
 * Time Complexity: O(2^n) - 2^n possible subsets
 * Space Complexity: O(n) - Recursion stack depth
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

// Alternative approach using iterative method
class SolutionIterative {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        
        int start = 0, end = 0;
        
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            
            // If current element is same as previous, start from previous end
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end;
            }
            
            end = result.size();
            
            for (int j = start; j < end; j++) {
                List<Integer> newSubset = new ArrayList<>(result.get(j));
                newSubset.add(nums[i]);
                result.add(newSubset);
            }
        }
        
        return result;
    }
}

// Alternative approach using Set
class SolutionSet {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, Set<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Alternative approach using bit manipulation
class SolutionBitManipulation {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
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
        
        return new ArrayList<>(result);
    }
}

// More concise version
class SolutionConcise {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Using frequency map
class SolutionFrequency {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(freq, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(Map<Integer, Integer> freq, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int num : freq.keySet()) {
            if (freq.get(num) > 0) {
                current.add(num);
                freq.put(num, freq.get(num) - 1);
                backtrack(freq, current, result);
                freq.put(num, freq.get(num) + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
