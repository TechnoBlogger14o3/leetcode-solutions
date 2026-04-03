class Solution:
    def maximumRobots(self, robots: List[int], distance: List[int], walls: List[int]) -> int:
        wall_set = set(walls)
        max_walls_destroyed = 0
        
        # Create a list of robot positions with their effective ranges
        robot_ranges = sorted((robots[i], robots[i] - distance[i], robots[i] + distance[i]) for i in range(len(robots)))
        
        # Set to track destroyed walls
        destroyed_walls = set()
        
        for pos, left_limit, right_limit in robot_ranges:
            # Check left direction
            for wall in range(left_limit, pos + 1):
                if wall in wall_set:
                    destroyed_walls.add(wall)
            # Check right direction
            for wall in range(pos, right_limit + 1):
                if wall in wall_set:
                    destroyed_walls.add(wall)
        
        return len(destroyed_walls)