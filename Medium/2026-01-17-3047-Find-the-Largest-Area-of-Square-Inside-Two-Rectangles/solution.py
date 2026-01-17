class Solution:
    def maxSquareArea(self, bottomLeft: List[List[int]], topRight: List[List[int]]) -> int:
        n = len(bottomLeft)
        max_side = 0
        
        for i in range(n):
            for j in range(i + 1, n):
                # Calculate intersection of rectangles i and j
                x1 = max(bottomLeft[i][0], bottomLeft[j][0])
                y1 = max(bottomLeft[i][1], bottomLeft[j][1])
                x2 = min(topRight[i][0], topRight[j][0])
                y2 = min(topRight[i][1], topRight[j][1])
                
                # Check if there is an intersection
                if x1 < x2 and y1 < y2:
                    # Calculate the side length of the largest square that can fit
                    side_length = min(x2 - x1, y2 - y1)
                    max_side = max(max_side, side_length)
        
        return max_side * max_side