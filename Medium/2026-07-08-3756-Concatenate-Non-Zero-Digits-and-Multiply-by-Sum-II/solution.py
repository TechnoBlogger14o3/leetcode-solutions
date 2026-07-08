class Solution:
    def concatenatedBinary(self, s: str, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7
        result = []
        
        for l, r in queries:
            substring = s[l:r + 1]
            non_zero_digits = ''.join(filter(lambda x: x != '0', substring))
            if not non_zero_digits:
                result.append(0)
                continue
            
            x = int(non_zero_digits)
            digit_sum = sum(int(d) for d in non_zero_digits)
            answer = (x * digit_sum) % MOD
            result.append(answer)
        
        return result