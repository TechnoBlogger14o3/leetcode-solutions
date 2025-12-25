class Solution:
    def maxHappiness(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        total_happiness = 0
        n = len(happiness)
        
        for i in range(k):
            total_happiness += happiness[i]
            decrement = min(i, n - k)  # Number of decrements that will affect the remaining children
            if decrement > 0:
                happiness[i + 1:n] = [max(0, h - decrement) for h in happiness[i + 1:n]]
        
        return total_happiness