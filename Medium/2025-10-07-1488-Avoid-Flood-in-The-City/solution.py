class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        from collections import defaultdict
        
        full_lakes = set()
        ans = [-1] * len(rains)
        dry_days = []
        
        for i, lake in enumerate(rains):
            if lake > 0:
                if lake in full_lakes:
                    return []
                full_lakes.add(lake)
                ans[i] = -1
            else:
                dry_days.append(i)
                ans[i] = 0
        
        for lake in full_lakes:
            if not dry_days:
                return []
            dry_day = dry_days.pop(0)
            ans[dry_day] = lake
        
        return ans