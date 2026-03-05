class Solution:
    def minOperations(self, s: str) -> int:
        count1 = count2 = 0
        for i in range(len(s)):
            expected_char1 = '0' if i % 2 == 0 else '1'
            expected_char2 = '1' if i % 2 == 0 else '0'
            if s[i] != expected_char1:
                count1 += 1
            if s[i] != expected_char2:
                count2 += 1
        return min(count1, count2)