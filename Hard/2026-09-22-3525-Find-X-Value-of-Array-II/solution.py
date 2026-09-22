class Solution:
    def findXValue(self, nums: List[int], k: int, queries: List[List[int]]) -> List[int]:
        from collections import defaultdict
        import math
        
        def mod_product_count(start, x):
            count = 0
            product = 1
            for i in range(start, len(nums)):
                product = (product * nums[i]) % k
                if product == x:
                    count += 1
            return count
        
        result = []
        for index, value, start, x in queries:
            nums[index] = value
            result.append(mod_product_count(start, x))
        
        return result