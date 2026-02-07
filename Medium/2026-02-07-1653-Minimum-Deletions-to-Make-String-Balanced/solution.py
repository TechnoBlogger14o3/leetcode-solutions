class Solution:
    def minimumDeletions(self, s: str) -> int:
        count_a = 0
        count_b = 0
        
        for char in s:
            if char == 'a':
                count_a += 1
            else:
                count_b += 1
                count_b = min(count_b, count_a)
        
        return count_b