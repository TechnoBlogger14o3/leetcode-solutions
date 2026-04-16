class Solution:
    def closestEqual(self, nums: List[int], queries: List[int]) -> List[int]:
        from collections import defaultdict
        
        index_map = defaultdict(list)
        n = len(nums)
        
        for i in range(n):
            index_map[nums[i]].append(i)
        
        result = []
        
        for query in queries:
            value = nums[query]
            indices = index_map[value]
            if len(indices) <= 1:
                result.append(-1)
                continue
            
            min_distance = float('inf')
            for idx in indices:
                distance = abs(idx - query)
                circular_distance = n - distance
                min_distance = min(min_distance, min(distance, circular_distance))
            
            result.append(min_distance)
        
        return result