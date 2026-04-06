class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        obstacle_set = set(map(tuple, obstacles))
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # North, East, South, West
        x, y, d = 0, 0, 0  # Starting position and direction index
        max_distance_sq = 0
        
        for command in commands:
            if command == -2:  # Turn left
                d = (d - 1) % 4
            elif command == -1:  # Turn right
                d = (d + 1) % 4
            else:  # Move forward
                for _ in range(command):
                    next_x = x + direction[d][0]
                    next_y = y + direction[d][1]
                    if (next_x, next_y) not in obstacle_set:
                        x, y = next_x, next_y
                        max_distance_sq = max(max_distance_sq, x * x + y * y)
                    else:
                        break
        
        return max_distance_sq