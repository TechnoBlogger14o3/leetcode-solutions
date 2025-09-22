from collections import Counter

class Solution:
    def countMaxFrequency(self, nums):
        freq = Counter(nums)
        max_freq = max(freq.values())
        return sum(count for count in freq.values() if count == max_freq)