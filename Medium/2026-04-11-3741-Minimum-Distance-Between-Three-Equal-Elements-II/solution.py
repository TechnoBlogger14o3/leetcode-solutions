class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        from collections import defaultdict
        indices = defaultdict(list)
        
        for i, num in enumerate(nums):
            indices[num].append(i)
        
        min_distance = float('inf')
        
        for idx_list in indices.values():
            if len(idx_list) < 3:
                continue
            for i in range(len(idx_list) - 2):
                for j in range(i + 1, len(idx_list) - 1):
                    for k in range(j + 1, len(idx_list)):
                        dist = abs(idx_list[i] - idx_list[j]) + abs(idx_list[j] - idx_list[k]) + abs(idx_list[k] - idx_list[i])
                        min_distance = min(min_distance, dist)
        
        return min_distance if min_distance != float('inf') else -1