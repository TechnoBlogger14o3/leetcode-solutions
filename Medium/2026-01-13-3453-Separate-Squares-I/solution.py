class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        events = []
        total_area = 0
        
        for x, y, l in squares:
            events.append((y, l, 1))  # start of square
            events.append((y + l, l, -1))  # end of square
            total_area += l * l
        
        events.sort()
        
        below_area = 0
        above_area = total_area
        last_y = events[0][0]
        
        for y, l, typ in events:
            if below_area == above_area:
                return last_y
            
            height = y - last_y
            if height > 0:
                below_area += height * (above_area - below_area)
            
            if typ == 1:
                below_area += l * l
            else:
                below_area -= l * l
            
            above_area = total_area - below_area
            last_y = y
        
        return last_y