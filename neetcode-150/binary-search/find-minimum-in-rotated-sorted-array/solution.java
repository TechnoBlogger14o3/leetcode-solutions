/**
 * Time Complexity: O(log n) - Binary search
 * Space Complexity: O(1) - Only uses constant extra space
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}

// Alternative approach using recursive binary search
class SolutionRecursive {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }
    
    private int findMinHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[right]) {
            return findMinHelper(nums, mid + 1, right);
        } else {
            return findMinHelper(nums, left, mid);
        }
    }
}

// Alternative approach comparing with leftmost element
class SolutionLeft {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return nums[left];
    }
}

// More concise version
class SolutionConcise {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        
        return nums[left];
    }
}

// Using bit manipulation for mid calculation
class SolutionBitManipulation {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) >>> 1; // Unsigned right shift
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}
