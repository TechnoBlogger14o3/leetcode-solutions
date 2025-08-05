from typing import List
from collections import defaultdict

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        basket = defaultdict(int)
        left = 0
        max_fruits = 0
        skip_count = 0
        
        for right in range(len(fruits)):
            basket[fruits[right]] += 1
            
            # If we have more than 2 types, we can skip at most one
            while len(basket) > 2 and skip_count < 1:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1
                skip_count += 1
            
            # If we still have more than 2 types, shrink window normally
            while len(basket) > 2:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1
            
            max_fruits = max(max_fruits, right - left + 1)
        
        return max_fruits 