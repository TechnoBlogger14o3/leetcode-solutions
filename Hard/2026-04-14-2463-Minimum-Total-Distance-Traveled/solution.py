class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort()
        
        dp = [float('inf')] * (len(robot) + 1)
        dp[0] = 0
        
        for position, limit in factory:
            new_dp = dp[:]
            for i in range(len(robot)):
                total_distance = 0
                for j in range(i, min(i + limit, len(robot))):
                    total_distance += abs(robot[j] - position)
                    new_dp[j + 1] = min(new_dp[j + 1], dp[i] + total_distance)
            dp = new_dp
        
        return dp[len(robot)]