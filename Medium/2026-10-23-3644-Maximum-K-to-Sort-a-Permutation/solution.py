class Solution:
    def maximumK(self, nums: List[int]) -> int:
        n = len(nums)
        if nums == sorted(nums):
            return 0
        
        max_k = 0
        for k in range(1 << 20):  # Check all possible k values up to 2^20
            can_sort = True
            visited = [False] * n
            
            for i in range(n):
                if visited[i]:
                    continue
                cycle = []
                x = i
                while not visited[x]:
                    visited[x] = True
                    cycle.append(nums[x])
                    x = nums[x]
                
                cycle.sort()
                if cycle != sorted(cycle):
                    can_sort = False
                    break
                
                # Check if we can sort this cycle with the current k
                for j in range(len(cycle)):
                    for l in range(j + 1, len(cycle)):
                        if (cycle[j] & cycle[l]) == k:
                            continue
                        else:
                            can_sort = False
                            break
                    if not can_sort:
                        break
            
            if can_sort:
                max_k = k
        
        return max_k