class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        def digit_product(x):
            product = 1
            while x > 0:
                product *= x % 10
                x //= 10
            return product
        
        while True:
            if digit_product(n) % t == 0:
                return n
            n += 1