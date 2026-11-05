class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        count = 0
        
        for num in arr1:
            if not any(abs(num - x) <= d for x in arr2):
                count += 1
                
        return count