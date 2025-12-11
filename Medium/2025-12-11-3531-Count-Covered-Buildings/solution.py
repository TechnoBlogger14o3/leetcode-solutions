class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        covered = set()
        building_set = set(map(tuple, buildings))
        
        for x, y in buildings:
            if (x - 1, y) in building_set and (x + 1, y) in building_set and (x, y - 1) in building_set and (x, y + 1) in building_set:
                covered.add((x, y))
        
        return len(covered)