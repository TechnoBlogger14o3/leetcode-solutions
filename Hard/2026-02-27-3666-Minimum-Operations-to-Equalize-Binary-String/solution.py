class Solution:
    def minOperations(self, s: str, k: int) -> int:
        count_zeros = s.count('0')
        if count_zeros == 0:
            return 0
        if count_zeros < k and count_zeros % k != 0:
            return -1
        
        operations = 0
        while count_zeros > 0:
            operations += 1
            count_zeros -= k
            if count_zeros < 0:
                return -1
        
        return operations