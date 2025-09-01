import heapq

class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def pass_ratio(pass_count, total_count):
            return (pass_count + 1) / (total_count + 1) - pass_count / total_count
        
        max_heap = []
        
        for pass_count, total_count in classes:
            heapq.heappush(max_heap, (-pass_ratio(pass_count, total_count), pass_count, total_count))
        
        for _ in range(extraStudents):
            ratio_diff, pass_count, total_count = heapq.heappop(max_heap)
            pass_count += 1
            total_count += 1
            heapq.heappush(max_heap, (-pass_ratio(pass_count, total_count), pass_count, total_count))
        
        total_average = 0
        for _, pass_count, total_count in max_heap:
            total_average += pass_count / total_count
        
        return total_average / len(classes)