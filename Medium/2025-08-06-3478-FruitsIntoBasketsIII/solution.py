from typing import List

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        min_unplaced = float('inf')
        
        # Try placing all fruits without skipping
        min_unplaced = min(min_unplaced, self.place_fruits(fruits, baskets, -1))
        
        # Try skipping each fruit type
        for skip_index in range(len(fruits)):
            min_unplaced = min(min_unplaced, self.place_fruits(fruits, baskets, skip_index))
        
        return min_unplaced
    
    def place_fruits(self, fruits: List[int], baskets: List[int], skip_index: int) -> int:
        used = [False] * len(baskets)
        unplaced = 0
        
        for i in range(len(fruits)):
            if i == skip_index:
                continue  # Skip this fruit
            
            placed = False
            
            # Find the leftmost available basket with sufficient capacity
            for j in range(len(baskets)):
                if not used[j] and baskets[j] >= fruits[i]:
                    used[j] = True  # Mark basket as used
                    placed = True
                    break
            
            if not placed:
                unplaced += 1
        
        return unplaced 