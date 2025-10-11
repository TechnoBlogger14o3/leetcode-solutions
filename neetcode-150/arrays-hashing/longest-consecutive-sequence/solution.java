import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n) - Each number visited at most twice
 * Space Complexity: O(n) - For HashSet
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : nums) {
            // Check if this is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentLength = 1;
                int currentNum = num;
                
                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentLength++;
                    currentNum++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // Skip duplicates
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                // Consecutive
                currentLength++;
            } else {
                // Not consecutive, reset
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        
        return Math.max(maxLength, currentLength);
    }
}

// Using streams for more functional approach
class SolutionStreams {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        return numSet.stream()
                .filter(num -> !numSet.contains(num - 1))
                .mapToInt(num -> {
                    int length = 1;
                    while (numSet.contains(num + length)) {
                        length++;
                    }
                    return length;
                })
                .max()
                .orElse(0);
    }
}
