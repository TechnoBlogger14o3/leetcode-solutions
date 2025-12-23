class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda x: x[1])
        max_value = 0
        dp = [0] * (len(events) + 1)
        
        for i in range(1, len(events) + 1):
            dp[i] = max(dp[i - 1], events[i - 1][2])
        
        for i in range(len(events)):
            start_time = events[i][0]
            end_time = events[i][1]
            value = events[i][2]
            left = 0
            right = i - 1
            
            while left <= right:
                mid = (left + right) // 2
                if events[mid][1] < start_time:
                    left = mid + 1
                else:
                    right = mid - 1
            
            if right >= 0:
                max_value = max(max_value, value + dp[right + 1])
            else:
                max_value = max(max_value, value)
        
        return max_value