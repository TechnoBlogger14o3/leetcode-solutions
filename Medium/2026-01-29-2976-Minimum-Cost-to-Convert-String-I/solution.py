from collections import defaultdict
import sys

class Solution:
    def minimumCost(self, source: str, target: str, original: list[str], changed: list[str], cost: list[int]) -> int:
        n = len(source)
        if n != len(target):
            return -1
        
        # Create a mapping from original to (changed, cost)
        change_map = defaultdict(list)
        for o, c, co in zip(original, changed, cost):
            change_map[o].append((c, co))
        
        total_cost = 0
        
        for s, t in zip(source, target):
            if s == t:
                continue
            
            if s not in change_map:
                return -1
            
            # Find the minimum cost to change s to t
            min_cost = sys.maxsize
            for c, co in change_map[s]:
                if c == t:
                    min_cost = min(min_cost, co)
                else:
                    # We can change c to t if c has a mapping
                    if c in change_map:
                        for cc, cco in change_map[c]:
                            if cc == t:
                                min_cost = min(min_cost, co + cco)
            
            if min_cost == sys.maxsize:
                return -1
            
            total_cost += min_cost
        
        return total_cost