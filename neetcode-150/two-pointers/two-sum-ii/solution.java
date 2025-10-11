/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two pointers
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[0]; // Should not reach here
    }
}

// Alternative approach using binary search
class SolutionBinarySearch {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == complement) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < complement) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return new int[0];
    }
}

// Using HashMap (not optimal for sorted array)
class SolutionHashMap {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement) + 1, i + 1};
            }
            
            numToIndex.put(numbers[i], i);
        }
        
        return new int[0];
    }
}
