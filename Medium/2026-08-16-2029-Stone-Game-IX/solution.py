class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        count = [0, 0, 0]
        for stone in stones:
            count[stone % 3] += 1
        
        if count[0] % 2 == 1:
            return count[1] > 0 and count[2] > 0
        else:
            return count[1] > 1 or count[2] > 1