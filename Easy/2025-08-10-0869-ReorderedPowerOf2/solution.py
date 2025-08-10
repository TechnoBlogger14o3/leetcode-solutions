from collections import Counter

class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        count = Counter(str(n))
        
        for i in range(31):
            if count == Counter(str(1 << i)):
                return True
        return False
