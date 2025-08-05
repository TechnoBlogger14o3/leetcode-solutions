from typing import List

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        used = [False] * len(baskets)
        unplaced = 0
        
        for fruit in fruits:
            placed = False
            
            # Find the leftmost available basket with sufficient capacity
            for i in range(len(baskets)):
                if not used[i] and baskets[i] >= fruit:
                    used[i] = True  # Mark basket as used
                    placed = True
                    break
            
            if not placed:
                unplaced += 1
        
        return unplaced 