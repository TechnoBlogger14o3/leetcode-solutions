#!/usr/bin/env python3
"""
Comprehensive script to generate all remaining Blind 75 solutions
"""

import os

# Define all remaining problems with their solutions
remaining_problems = {
    # String problems
    "longest-repeating-character-replacement": {
        "java": """class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}""",
        "js": """/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
    const count = new Array(26).fill(0);
    let maxCount = 0;
    let maxLength = 0;
    let left = 0;
    
    for (let right = 0; right < s.length; right++) {
        count[s.charCodeAt(right) - 65]++;
        maxCount = Math.max(maxCount, count[s.charCodeAt(right) - 65]);
        
        if (right - left + 1 - maxCount > k) {
            count[s.charCodeAt(left) - 65]--;
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};""",
        "py": """class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = [0] * 26
        max_count = 0
        max_length = 0
        left = 0
        
        for right in range(len(s)):
            count[ord(s[right]) - ord('A')] += 1
            max_count = max(max_count, count[ord(s[right]) - ord('A')])
            
            if right - left + 1 - max_count > k:
                count[ord(s[left]) - ord('A')] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length"""
    },
    
    "minimum-window-substring": {
        "java": """import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int required = need.size();
        int formed = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            have.put(c, have.getOrDefault(c, 0) + 1);
            
            if (need.containsKey(c) && have.get(c).equals(need.get(c))) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                have.put(c, have.get(c) - 1);
                if (need.containsKey(c) && have.get(c) < need.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}""",
        "js": """/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    const need = new Map();
    const have = new Map();
    
    for (const char of t) {
        need.set(char, (need.get(char) || 0) + 1);
    }
    
    let left = 0, right = 0;
    let minLen = Infinity;
    let minStart = 0;
    const required = need.size;
    let formed = 0;
    
    while (right < s.length) {
        const char = s[right];
        have.set(char, (have.get(char) || 0) + 1);
        
        if (need.has(char) && have.get(char) === need.get(char)) {
            formed++;
        }
        
        while (left <= right && formed === required) {
            const leftChar = s[left];
            
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            
            have.set(leftChar, have.get(leftChar) - 1);
            if (need.has(leftChar) && have.get(leftChar) < need.get(leftChar)) {
                formed--;
            }
            left++;
        }
        right++;
    }
    
    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};""",
        "py": """class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = {}
        have = {}
        
        for char in t:
            need[char] = need.get(char, 0) + 1
        
        left = right = 0
        min_len = float('inf')
        min_start = 0
        required = len(need)
        formed = 0
        
        while right < len(s):
            char = s[right]
            have[char] = have.get(char, 0) + 1
            
            if char in need and have[char] == need[char]:
                formed += 1
            
            while left <= right and formed == required:
                left_char = s[left]
                
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_start = left
                
                have[left_char] -= 1
                if left_char in need and have[left_char] < need[left_char]:
                    formed -= 1
                left += 1
            right += 1
        
        return s[min_start:min_start + min_len] if min_len != float('inf') else """""
    },
    
    # Tree problems
    "same-tree": {
        "java": """class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}""",
        "js": """/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    if (!p && !q) {
        return true;
    }
    if (!p || !q) {
        return false;
    }
    if (p.val !== q.val) {
        return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};""",
        "py": """class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)"""
    },
    
    "invert-binary-tree": {
        "java": """class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}""",
        "js": """/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    if (!root) {
        return null;
    }
    
    const left = invertTree(root.left);
    const right = invertTree(root.right);
    
    root.left = right;
    root.right = left;
    
    return root;
};""",
        "py": """class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        
        root.left = right
        root.right = left
        
        return root"""
    },
    
    # Heap problems
    "find-median-from-data-stream": {
        "java": """import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left half
    private PriorityQueue<Integer> minHeap; // right half
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}""",
        "js": """/**
 * initialize your data structure here.
 */
var MedianFinder = function() {
    this.maxHeap = new MaxPriorityQueue(); // left half
    this.minHeap = new MinPriorityQueue(); // right half
};

/** 
 * @param {number} num
 * @return {void}
 */
MedianFinder.prototype.addNum = function(num) {
    this.maxHeap.enqueue(num);
    this.minHeap.enqueue(this.maxHeap.dequeue().element);
    
    if (this.maxHeap.size() < this.minHeap.size()) {
        this.maxHeap.enqueue(this.minHeap.dequeue().element);
    }
};

/**
 * @return {number}
 */
MedianFinder.prototype.findMedian = function() {
    if (this.maxHeap.size() > this.minHeap.size()) {
        return this.maxHeap.front().element;
    }
    return (this.maxHeap.front().element + this.minHeap.front().element) / 2;
};""",
        "py": """import heapq

class MedianFinder:
    def __init__(self):
        self.max_heap = []  # left half
        self.min_heap = []  # right half
    
    def addNum(self, num: int) -> None:
        heapq.heappush(self.max_heap, -num)
        heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        
        if len(self.max_heap) < len(self.min_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))
    
    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return -self.max_heap[0]
        return (-self.max_heap[0] + self.min_heap[0]) / 2"""
    }
}

def create_all_solutions():
    """Create solution files for all remaining problems"""
    for problem_name, solutions in remaining_problems.items():
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
    create_all_solutions()
