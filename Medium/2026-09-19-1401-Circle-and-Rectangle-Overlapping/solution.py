class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        closest_x = max(x1, min(xCenter, x2))
        closest_y = max(y1, min(yCenter, y2))
        
        distance_x = xCenter - closest_x
        distance_y = yCenter - closest_y
        
        return (distance_x * distance_x + distance_y * distance_y) <= (radius * radius)