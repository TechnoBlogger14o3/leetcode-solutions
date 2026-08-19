class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        reserved = defaultdict(set)
        for row, seat in reservedSeats:
            reserved[row].add(seat)
        
        max_groups = 0
        
        for row in range(1, n + 1):
            if row in reserved:
                seats = reserved[row]
                groups = 0
                
                if all(seat not in seats for seat in [2, 3, 4, 5]):
                    groups += 1
                if all(seat not in seats for seat in [4, 5, 6, 7]):
                    groups += 1
                if all(seat not in seats for seat in [6, 7, 8, 9]):
                    groups += 1
                
                max_groups += groups
            else:
                max_groups += 2  # Two groups can be seated in a completely free row
        
        return max_groups