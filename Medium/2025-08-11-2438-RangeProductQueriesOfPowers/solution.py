class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7
        
        # Generate powers array
        powers = []
        for i in range(31):
            if n & (1 << i):
                powers.append(1 << i)
        
        # Compute prefix products
        prefix = [1] * len(powers)
        if powers:
            prefix[0] = powers[0]
            for i in range(1, len(powers)):
                prefix[i] = (prefix[i-1] * powers[i]) % MOD
        
        # Process queries
        answer = []
        for left, right in queries:
            if left == 0:
                answer.append(prefix[right])
            else:
                # Use pow with modulo for efficient inverse
                inverse = pow(prefix[left-1], -1, MOD)
                answer.append((prefix[right] * inverse) % MOD)
        
        return answer
