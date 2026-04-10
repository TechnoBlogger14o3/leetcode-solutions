class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        from collections import defaultdict
        indices = defaultdict(list)
        
        for i, num in enumerate(nums):
            indices[num].append(i)
        
        min_distance = float('inf')
        found = False
        
        for idx_list in indices.values():
            if len(idx_list) >= 3:
                for i in range(len(idx_list) - 2):
                    for j in range(i + 1, len(idx_list) - 1):
                        for k in range(j + 1, len(idx_list)):
                            distance = abs(idx_list[i] - idx_list[j]) + abs(idx_list[j] - idx_list[k]) + abs(idx_list[k] - idx_list[i])
                            min_distance = min(min_distance, distance)
                            found = True
        
        return min_distance if found else -1