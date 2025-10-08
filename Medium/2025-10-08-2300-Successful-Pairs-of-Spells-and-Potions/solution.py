from bisect import bisect_left
from typing import List

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        result = []
        for spell in spells:
            required = (success + spell - 1) // spell  # equivalent to ceil(success / spell)
            count = len(potions) - bisect_left(potions, required)
            result.append(count)
        return result