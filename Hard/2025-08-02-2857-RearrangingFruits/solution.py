from collections import defaultdict
from typing import List

class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        n = len(basket1)
        
        map1 = defaultdict(int)
        map2 = defaultdict(int)
        min_val = float('inf')
        
        for i in range(n):
            map1[basket1[i]] += 1
            map2[basket2[i]] += 1
            min_val = min(min_val, basket1[i])
            min_val = min(min_val, basket2[i])
        
        swap_list1 = []
        for key in map1:
            c1 = map1[key]
            c2 = map2.get(key, 0)
            if (c1 + c2) % 2 == 1:
                return -1
            if c1 > c2:
                add_cnt = (c1 - c2) // 2
                for _ in range(add_cnt):
                    swap_list1.append(key)
        
        swap_list2 = []
        for key in map2:
            c1 = map1.get(key, 0)
            c2 = map2[key]
            if (c1 + c2) % 2 == 1:
                return -1
            if c2 > c1:
                add_cnt = (c2 - c1) // 2
                for _ in range(add_cnt):
                    swap_list2.append(key)
        
        swap_list1.sort()
        swap_list2.sort(reverse=True)
        
        res = 0
        for i in range(len(swap_list1)):
            res += min(2 * min_val, 
                      min(swap_list1[i], swap_list2[i]))
        
        return res 