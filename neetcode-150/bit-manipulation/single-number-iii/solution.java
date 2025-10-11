/**
 * Time Complexity: O(n) - Two passes
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        // XOR all elements to get XOR of two single numbers
        for (int num : nums) {
            xor ^= num;
        }
        
        // Find rightmost set bit
        int rightmostSetBit = xor & (-xor);
        
        int num1 = 0, num2 = 0;
        
        // Partition array based on rightmost set bit
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}

// Alternative approach using hash map
class SolutionHashMap {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int[] result = new int[2];
        int index = 0;
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }
        
        return result;
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                result[index++] = nums[i];
            } else {
                i++; // Skip the next element
            }
        }
        
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        int rightmostSetBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmostSetBit) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        
        return new int[]{num1, num2};
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        
        while (i < nums.length) {
            xor ^= nums[i];
            i++;
        }
        
        int rightmostSetBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        i = 0;
        
        while (i < nums.length) {
            if ((nums[i] & rightmostSetBit) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
            i++;
        }
        
        return new int[]{num1, num2};
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for (int num : nums) {
            xor ^= num;
        }
        
        int rightmostSetBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        int rightmostSetBit = xor & (-xor);
        int[] result = new int[2];
        
        singleNumberHelper(nums, 0, rightmostSetBit, result);
        
        return result;
    }
    
    private void singleNumberHelper(int[] nums, int index, int rightmostSetBit, int[] result) {
        if (index >= nums.length) {
            return;
        }
        
        if ((nums[index] & rightmostSetBit) == 0) {
            result[0] ^= nums[index];
        } else {
            result[1] ^= nums[index];
        }
        
        singleNumberHelper(nums, index + 1, rightmostSetBit, result);
    }
}

// Alternative approach using mathematical
class SolutionMathematical {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long uniqueSum = 0;
        
        for (int num : nums) {
            sum += num;
            if (set.add(num)) {
                uniqueSum += num;
            }
        }
        
        int diff = (int) ((2 * uniqueSum - sum) / 2);
        int[] result = new int[2];
        
        for (int num : nums) {
            if (set.contains(num - diff)) {
                result[0] = num;
                result[1] = num - diff;
                break;
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        
        int rightmostSetBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}
