class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        count = 0
        end = 0
        
        for interval in intervals:
            if interval[1] > end:
                count += 1
                end = interval[1]
        
        return count