/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}

// Alternative approach using XOR operation
class SolutionXOR {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        
        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        
        // XOR all numbers in array
        for (int num : nums) {
            xor ^= num;
        }
        
        return xor;
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
}

// Alternative approach using hash set
class SolutionHashSet {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return -1; // Should never reach here
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        
        return expectedSum - actualSum;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        int i = 0;
        
        while (i < nums.length) {
            actualSum += nums[i];
            i++;
        }
        
        return expectedSum - actualSum;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = sumHelper(nums, 0);
        
        return expectedSum - actualSum;
    }
    
    private int sumHelper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        
        return nums[index] + sumHelper(nums, index + 1);
    }
}

// Alternative approach using binary search
class SolutionBinarySearch {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

// More concise version
class SolutionConcise {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) actualSum += num;
        
        return expectedSum - actualSum;
    }
}
