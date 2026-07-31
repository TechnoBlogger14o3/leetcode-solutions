class Solution:
    def minimumPushes(self, word: str) -> int:
        from collections import Counter
        
        count = Counter(word)
        frequencies = sorted(count.values(), reverse=True)
        
        pushes = 0
        for i, freq in enumerate(frequencies):
            pushes += (i // 3 + 1) * freq
        
        return pushes