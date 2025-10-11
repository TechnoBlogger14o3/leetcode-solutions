import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - HashMap can store up to n elements
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            
            numToIndex.put(nums[i], i);
        }
        
        return new int[0]; // Should not reach here
    }
}

// Brute force approach (not recommended for large inputs)
class SolutionBruteForce {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

// Two-pass approach
class SolutionTwoPass {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        // First pass: build the map
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        
        // Second pass: find the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement) && numToIndex.get(complement) != i) {
                return new int[]{i, numToIndex.get(complement)};
            }
        }
        
        return new int[0];
    }
}
