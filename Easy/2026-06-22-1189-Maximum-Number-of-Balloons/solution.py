class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        from collections import Counter
        
        count = Counter(text)
        return min(count['b'], count['a'], count['l'] // 2, count['o'] // 2, count['n'])