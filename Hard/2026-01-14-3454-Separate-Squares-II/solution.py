class Solution:
    def minY(self, squares: List[List[int]]) -> float:
        events = []
        for x, y, l in squares:
            events.append((x, y, y + l, 1))  # Start of square
            events.append((x + l, y, y + l, -1))  # End of square
        
        events.sort()
        
        active_intervals = []
        total_area = 0
        
        def calculate_area():
            if not active_intervals:
                return 0
            total = 0
            current_start = -1
            current_end = -1
            for start, end in active_intervals:
                if current_end < start:
                    total += current_end - current_start
                    current_start = start
                    current_end = end
                else:
                    current_end = max(current_end, end)
            total += current_end - current_start
            return total
        
        last_x = events[0][0]
        for x, y1, y2, typ in events:
            total_area += calculate_area() * (x - last_x)
            if typ == 1:
                active_intervals.append((y1, y2))
                active_intervals.sort()
            else:
                active_intervals.remove((y1, y2))
            last_x = x
        
        half_area = total_area / 2
        current_area = 0
        last_y = 0
        
        for y in sorted(set(y for _, y1, y2, _ in events for y in (y1, y2))):
            current_area += calculate_area() * (y - last_y)
            if current_area >= half_area:
                return float(y)
            last_y = y
        
        return -1.0