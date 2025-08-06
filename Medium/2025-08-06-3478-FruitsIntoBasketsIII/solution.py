from typing import List
import bisect

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        min_unplaced = float('inf')
        
        # Try placing all fruits without skipping
        min_unplaced = min(min_unplaced, self.place_fruits_optimized(fruits, baskets, -1))
        
        # Try skipping each fruit type
        for skip_index in range(len(fruits)):
            min_unplaced = min(min_unplaced, self.place_fruits_optimized(fruits, baskets, skip_index))
        
        return min_unplaced
    
    def place_fruits_optimized(self, fruits: List[int], baskets: List[int], skip_index: int) -> int:
        # Use sorted list to maintain available baskets efficiently
        available_baskets = sorted(baskets)
        unplaced = 0
        
        for i in range(len(fruits)):
            if i == skip_index:
                unplaced += 1  # Count skipped fruit as unplaced
                continue
            
            # Find the smallest available basket that can hold this fruit
            basket_index = -1
            for j in range(len(available_baskets)):
                if available_baskets[j] >= fruits[i]:
                    basket_index = j
                    break
            
            if basket_index == -1:
                unplaced += 1
            else:
                available_baskets.pop(basket_index)  # Remove used basket
        
        return unplaced 