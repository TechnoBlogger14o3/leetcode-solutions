/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}

// Alternative approach using hash map
class SolutionHashMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1; // Should never reach here
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        
        return nums[nums.length - 1];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    count++;
                }
            }
            
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int singleNumber(int[] nums) {
        int result = 0;
        int i = 0;
        
        while (i < 32) {
            int count = 0;
            int j = 0;
            
            while (j < nums.length) {
                if (((nums[j] >> i) & 1) == 1) {
                    count++;
                }
                j++;
            }
            
            if (count % 3 != 0) {
                result |= (1 << i);
            }
            
            i++;
        }
        
        return result;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int singleNumber(int[] nums) {
        return singleNumberHelper(nums, 0, 0);
    }
    
    private int singleNumberHelper(int[] nums, int bitPos, int result) {
        if (bitPos >= 32) {
            return result;
        }
        
        int count = 0;
        for (int num : nums) {
            if (((num >> bitPos) & 1) == 1) {
                count++;
            }
        }
        
        if (count % 3 != 0) {
            result |= (1 << bitPos);
        }
        
        return singleNumberHelper(nums, bitPos + 1, result);
    }
}

// Alternative approach using mathematical
class SolutionMathematical {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long uniqueSum = 0;
        
        for (int num : nums) {
            sum += num;
            if (set.add(num)) {
                uniqueSum += num;
            }
        }
        
        return (int) ((3 * uniqueSum - sum) / 2);
    }
}

// More concise version
class SolutionConcise {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) count++;
            }
            if (count % 3 != 0) result |= (1 << i);
        }
        return result;
    }
}
