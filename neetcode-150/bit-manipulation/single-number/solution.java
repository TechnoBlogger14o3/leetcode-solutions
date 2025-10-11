/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}

// Alternative approach using hash set
class SolutionHashSet {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        
        return set.iterator().next();
    }
}

// Alternative approach using mathematical sum
class SolutionMathematical {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int uniqueSum = 0;
        
        for (int num : nums) {
            sum += num;
            if (set.add(num)) {
                uniqueSum += num;
            }
        }
        
        return 2 * uniqueSum - sum;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        return result;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int singleNumber(int[] nums) {
        int result = 0;
        int i = 0;
        
        while (i < nums.length) {
            result ^= nums[i];
            i++;
        }
        
        return result;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int singleNumber(int[] nums) {
        return singleNumberHelper(nums, 0, 0);
    }
    
    private int singleNumberHelper(int[] nums, int index, int result) {
        if (index >= nums.length) {
            return result;
        }
        
        return singleNumberHelper(nums, index + 1, result ^ nums[index]);
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        
        return nums[nums.length - 1];
    }
}

// Alternative approach using frequency map
class SolutionFrequencyMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1; // Should never reach here
    }
}

// More concise version
class SolutionConcise {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}
