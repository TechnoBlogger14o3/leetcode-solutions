from typing import List

class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        # Sort fruits by position
        fruits.sort(key=lambda x: x[0])
        
        n = len(fruits)
        max_fruits = 0
        
        # Try all possible ranges
        for left in range(n):
            for right in range(left, n):
                left_pos = fruits[left][0]
                right_pos = fruits[right][0]
                
                # Calculate minimum steps needed
                steps = right_pos - left_pos + min(abs(startPos - left_pos), abs(startPos - right_pos))
                
                if steps <= k:
                    # Calculate total fruits in this range
                    total_fruits = sum(fruits[i][1] for i in range(left, right + 1))
                    max_fruits = max(max_fruits, total_fruits)
        
        return max_fruits 