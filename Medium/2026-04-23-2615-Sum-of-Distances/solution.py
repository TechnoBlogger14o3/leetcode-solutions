class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        from collections import defaultdict
        
        index_map = defaultdict(list)
        n = len(nums)
        arr = [0] * n
        
        for i in range(n):
            index_map[nums[i]].append(i)
        
        for indices in index_map.values():
            if len(indices) < 2:
                continue
            
            total = sum(indices)
            count = len(indices)
            for i in range(count):
                left_count = i
                right_count = count - i - 1
                left_sum = indices[i] * left_count - sum(indices[:i])
                right_sum = sum(indices[i + 1:]) - indices[i] * right_count
                arr[indices[i]] = left_sum + right_sum
        
        return arr