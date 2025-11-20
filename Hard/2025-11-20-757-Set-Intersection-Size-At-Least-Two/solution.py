class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[1], x[0]))
        end1, end2 = -1, -1
        count = 0
        
        for start, end in intervals:
            if end1 < start:
                count += 2
                end1, end2 = end - 1, end
            elif end2 < start:
                count += 1
                end1, end2 = end2, end
            
            end1 = max(end1, end - 1)
            end2 = max(end2, end)
        
        return count