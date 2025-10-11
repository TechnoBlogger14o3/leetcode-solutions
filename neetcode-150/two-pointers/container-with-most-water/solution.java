/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two pointers
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate area
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}

// Alternative approach using brute force
class SolutionBruteForce {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}

// More concise version
class SolutionConcise {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            maxArea = Math.max(maxArea, 
                Math.min(height[left], height[right]) * (right - left));
            
            if (height[left] < height[right]) left++;
            else right--;
        }
        
        return maxArea;
    }
}
