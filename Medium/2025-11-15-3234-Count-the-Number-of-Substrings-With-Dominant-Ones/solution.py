class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        total_substrings = n * (n + 1) // 2
        non_dominant_count = 0
        
        for i in range(n):
            zeros = 0
            ones = 0
            for j in range(i, n):
                if s[j] == '0':
                    zeros += 1
                else:
                    ones += 1
                if ones < zeros * zeros:
                    non_dominant_count += 1
        
        return total_substrings - non_dominant_count