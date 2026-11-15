class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MOD = 10**9 + 7
        odd_count = 0
        even_count = 1
        current_sum = 0
        result = 0
        
        for num in arr:
            current_sum += num
            if current_sum % 2 == 0:
                result += odd_count
                even_count += 1
            else:
                result += even_count
                odd_count += 1
            
            result %= MOD
        
        return result