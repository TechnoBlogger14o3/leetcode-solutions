class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        def waviness(n: int) -> int:
            s = str(n)
            count = 0
            for i in range(1, len(s) - 1):
                if (s[i] > s[i - 1] and s[i] > s[i + 1]) or (s[i] < s[i - 1] and s[i] < s[i + 1]):
                    count += 1
            return count
        
        total_waviness = 0
        for num in range(num1, num2 + 1):
            total_waviness += waviness(num)
        
        return total_waviness