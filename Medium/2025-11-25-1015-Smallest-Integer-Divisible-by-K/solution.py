class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        if k % 2 == 0 or k % 5 == 0:
            return -1
        
        length = 1
        num = 1 % k
        
        while num != 0:
            num = (num * 10 + 1) % k
            length += 1
            
        return length