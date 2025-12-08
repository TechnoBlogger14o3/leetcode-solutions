from collections import Counter
import heapq

class Solution:
    def reorganizeString(self, s: str) -> str:
        count = Counter(s)
        max_count = max(count.values())
        if max_count > (len(s) + 1) // 2:
            return ""
        
        heap = [(-freq, char) for char, freq in count.items()]
        heapq.heapify(heap)
        
        result = []
        prev = None
        
        while heap:
            freq, char = heapq.heappop(heap)
            result.append(char)
            
            if prev and prev[0] < 0:
                heapq.heappush(heap, prev)
            
            prev = (freq + 1, char) if freq + 1 < 0 else None
        
        return "".join(result)
