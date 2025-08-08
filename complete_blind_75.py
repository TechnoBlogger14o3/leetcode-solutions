#!/usr/bin/env python3
"""
Script to generate all remaining Blind 75 solutions
"""

import os

# Define all remaining problems with their solutions
problems = {
    # String problems
    "longest-substring-without-repeating-characters": {
        "java": """import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            charSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}""",
        "js": """/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const n = s.length;
    let maxLength = 0;
    let left = 0;
    const charSet = new Set();
    
    for (let right = 0; right < n; right++) {
        const currentChar = s[right];
        
        while (charSet.has(currentChar)) {
            charSet.delete(s[left]);
            left++;
        }
        
        charSet.add(currentChar);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};""",
        "py": """class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        max_length = 0
        left = 0
        char_set = set()
        
        for right in range(n):
            current_char = s[right]
            
            while current_char in char_set:
                char_set.remove(s[left])
                left += 1
            
            char_set.add(current_char)
            max_length = max(max_length, right - left + 1)
        
        return max_length"""
    },
    
    # Tree problems
    "maximum-depth-of-binary-tree": {
        "java": """class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}""",
        "js": """/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    if (!root) {
        return 0;
    }
    
    const leftDepth = maxDepth(root.left);
    const rightDepth = maxDepth(root.right);
    
    return Math.max(leftDepth, rightDepth) + 1;
};""",
        "py": """class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        left_depth = self.maxDepth(root.left)
        right_depth = self.maxDepth(root.right)
        
        return max(left_depth, right_depth) + 1"""
    },
    
    # Heap problems
    "kth-largest-element-in-an-array": {
        "java": """import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}""",
        "js": """/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    const minHeap = new MinPriorityQueue();
    
    for (const num of nums) {
        minHeap.enqueue(num);
        if (minHeap.size() > k) {
            minHeap.dequeue();
        }
    }
    
    return minHeap.front().element;
};""",
        "py": """import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []
        
        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return min_heap[0]"""
    }
}

def create_solution_files():
    """Create solution files for all problems"""
    for problem_name, solutions in problems.items():
        # Create directory if it doesn't exist
        problem_dir = f"blind-75/{problem_name}"
        if not os.path.exists(problem_dir):
            os.makedirs(problem_dir)
        
        # Create solution files
        for lang, code in solutions.items():
            filename = f"{problem_dir}/solution.{lang}"
            with open(filename, 'w') as f:
                f.write(code)
        
        print(f"Created solutions for {problem_name}")

if __name__ == "__main__":
    create_solution_files()
