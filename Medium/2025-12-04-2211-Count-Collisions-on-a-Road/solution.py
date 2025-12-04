class Solution:
    def countCollisions(self, directions: str) -> int:
        collisions = 0
        n = len(directions)
        
        # Process from left to right
        for i in range(n):
            if directions[i] == 'R':
                if i + 1 < n and directions[i + 1] == 'L':
                    collisions += 2
                    directions = directions[:i] + 'S' + directions[i + 1:i + 1] + 'S' + directions[i + 2:]
                elif i + 1 < n and directions[i + 1] == 'S':
                    collisions += 1
                    directions = directions[:i] + 'S' + directions[i + 1:]
        
        # Process from right to left
        for i in range(n - 1, -1, -1):
            if directions[i] == 'L':
                if i - 1 >= 0 and directions[i - 1] == 'R':
                    collisions += 2
                    directions = directions[:i] + 'S' + directions[i + 1:]
                elif i - 1 >= 0 and directions[i - 1] == 'S':
                    collisions += 1
                    directions = directions[:i] + 'S' + directions[i + 1:]

        return collisions