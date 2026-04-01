class Solution:
    def surviveRobots(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        robots = sorted(zip(positions, healths, directions))
        stack = []
        
        for pos, health, direction in robots:
            if direction == 'R':
                stack.append([health])
            else:
                while stack and stack[-1][0] > 0:
                    if stack[-1][0] < health:
                        health -= 1
                        stack.pop()
                    elif stack[-1][0] == health:
                        health = 0
                        stack.pop()
                        break
                    else:
                        health = 0
                        break
                if health > 0:
                    stack.append([health])
        
        return [h[0] for h in stack if h[0] > 0]