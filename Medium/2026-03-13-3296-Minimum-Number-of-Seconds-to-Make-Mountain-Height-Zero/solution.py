class Solution:
    def minimumSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def time_to_reduce(worker_time, x):
            return worker_time * x * (x + 1) // 2
        
        n = len(workerTimes)
        left, right = 1, mountainHeight * max(workerTimes) * (mountainHeight + 1) // 2
        
        while left < right:
            mid = (left + right) // 2
            total_reduction = 0
            
            for worker_time in workerTimes:
                max_x = int((2 * mid) // worker_time)
                total_reduction += max_x
            
            if total_reduction >= mountainHeight:
                right = mid
            else:
                left = mid + 1
        
        return left