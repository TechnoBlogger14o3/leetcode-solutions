from typing import List

class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        # Sort fruits by position
        fruits.sort(key=lambda x: x[0])
        
        n = len(fruits)
        max_fruits = 0
        left = 0
        current_sum = 0
        
        # Sliding window approach
        for right in range(n):
            current_sum += fruits[right][1]
            
            # Shrink window from left while it's invalid
            while left <= right:
                left_pos = fruits[left][0]
                right_pos = fruits[right][0]
                
                # Calculate minimum steps needed for current window
                steps = right_pos - left_pos + min(abs(startPos - left_pos), abs(startPos - right_pos))
                
                if steps <= k:
                    break  # Window is valid, keep it
                
                # Remove leftmost fruit and shrink window
                current_sum -= fruits[left][1]
                left += 1
            
            # Update max fruits if window is valid
            if left <= right:
                max_fruits = max(max_fruits, current_sum)
        
        return max_fruits 