class Solution:
    def smallestDivisible(self, num: str, t: int) -> str:
        def product_of_digits(s: str) -> int:
            prod = 1
            for char in s:
                prod *= int(char)
            return prod
        
        n = len(num)
        num_int = int(num)
        
        while True:
            if '0' in str(num_int):
                num_int += 1
                continue
            
            if product_of_digits(str(num_int)) % t == 0:
                return str(num_int)
            
            num_int += 1
            
            if num_int > 10**(n + 1):
                break
        
        return "-1"