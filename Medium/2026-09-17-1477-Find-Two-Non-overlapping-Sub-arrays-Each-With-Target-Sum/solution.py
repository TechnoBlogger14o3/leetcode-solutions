class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        n = len(arr)
        prefix_sum = {0: -1}
        current_sum = 0
        min_length = float('inf')
        lengths = [float('inf')] * n
        
        for i in range(n):
            current_sum += arr[i]
            if current_sum - target in prefix_sum:
                start_index = prefix_sum[current_sum - target]
                lengths[i] = i - start_index
            
            prefix_sum[current_sum] = i
        
        for i in range(n):
            if i > 0:
                lengths[i] = min(lengths[i], lengths[i - 1])
            if lengths[i] < float('inf') and i + 1 < n:
                min_length = min(min_length, lengths[i] + lengths[i + 1])
        
        return min_length if min_length < float('inf') else -1