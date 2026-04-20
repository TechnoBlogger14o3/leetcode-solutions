class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        left_color = colors[0]
        right_color = colors[-1]
        n = len(colors)
        
        # Find the furthest house with a different color from the leftmost house
        max_distance = 0
        for i in range(n):
            if colors[i] != left_color:
                max_distance = max(max_distance, i)
                break
        
        # Find the furthest house with a different color from the rightmost house
        for i in range(n - 1, -1, -1):
            if colors[i] != right_color:
                max_distance = max(max_distance, n - 1 - i)
                break
        
        return max_distance