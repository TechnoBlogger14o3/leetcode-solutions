class Solution:
    def maximumTotalValue(self, nums: List[int], k: int) -> int:
        n = len(nums)
        values = []
        
        for i in range(n):
            current_max = nums[i]
            current_min = nums[i]
            for j in range(i, n):
                current_max = max(current_max, nums[j])
                current_min = min(current_min, nums[j])
                values.append(current_max - current_min)
        
        values.sort(reverse=True)
        return sum(values[:k])