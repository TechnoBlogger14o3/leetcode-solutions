class Solution:
    def minMoves(self, nums: List[int], limit: int) -> int:
        n = len(nums)
        moves = [0] * (2 * limit + 2)
        
        for i in range(n // 2):
            a, b = nums[i], nums[n - 1 - i]
            low = min(a + b, 2 * limit + 1)
            high = max(a + b + 1, 1)
            moves[high] += 1
            moves[low] -= 1
        
        min_moves = float('inf')
        current_moves = 0
        
        for i in range(1, 2 * limit + 1):
            current_moves += moves[i]
            min_moves = min(min_moves, current_moves)
        
        return min_moves