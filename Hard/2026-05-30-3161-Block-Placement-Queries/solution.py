class Solution:
    def blockPlacementQueries(self, queries: List[List[int]]) -> List[bool]:
        obstacles = set()
        results = []
        
        for query in queries:
            if query[0] == 1:
                obstacles.add(query[1])
            else:
                x, sz = query[1], query[2]
                can_place = True
                for obs in obstacles:
                    if obs <= x and obs >= (x - sz + 1):
                        can_place = False
                        break
                results.append(can_place)
        
        return results