class Solution:
    def maxNumOfSubstrings(self, s: str) -> List[str]:
        n = len(s)
        first = {}
        last = {}
        
        for i in range(n):
            if s[i] not in first:
                first[s[i]] = i
            last[s[i]] = i
        
        intervals = []
        
        for c in first:
            start = first[c]
            end = last[c]
            for i in range(start, end + 1):
                if s[i] in last:
                    end = max(end, last[s[i]])
            intervals.append((start, end))
        
        intervals.sort(key=lambda x: (x[1], x[0]))
        
        result = []
        current_end = -1
        
        for start, end in intervals:
            if start > current_end:
                result.append(s[start:end + 1])
                current_end = end
        
        return result