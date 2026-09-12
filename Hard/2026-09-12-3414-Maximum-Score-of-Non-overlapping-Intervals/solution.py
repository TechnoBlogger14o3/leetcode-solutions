class Solution:
    def maximumScore(self, intervals: List[List[int]]) -> List[int]:
        intervals = sorted((l, r, w, i) for i, (l, r, w) in enumerate(intervals))
        n = len(intervals)
        dp = [[0] * 5 for _ in range(n + 1)]
        prev = [-1] * n
        
        for i in range(n):
            l1, r1, w1, idx1 = intervals[i]
            for j in range(i):
                l2, r2, w2, idx2 = intervals[j]
                if r2 < l1:
                    prev[i] = j
        
        for i in range(1, n + 1):
            l, r, w, idx = intervals[i - 1]
            for j in range(1, 5):
                dp[i][j] = max(dp[i - 1][j], dp[prev[i - 1] + 1][j - 1] + w)
        
        max_score = max(dp[n])
        result = []
        
        for j in range(4, 0, -1):
            for i in range(n, 0, -1):
                if dp[i][j] == max_score:
                    l, r, w, idx = intervals[i - 1]
                    result.append(idx)
                    max_score -= w
                    i = prev[i - 1] + 1
                    break
        
        return sorted(result[:4])