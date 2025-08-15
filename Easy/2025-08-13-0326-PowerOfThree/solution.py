class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        # Handle edge cases
        if n <= 0:
            return False
        if n == 1:
            return True
        
        # Keep dividing by 3 until we can't
        while n % 3 == 0:
            n //= 3
        
        # If we end up with 1, it's a power of 3
        return n == 1

# Alternative approach using mathematical properties
class Solution2:
    def isPowerOfThree(self, n: int) -> bool:
        # The largest power of 3 that fits in Python int is 3^19 = 1162261467
        # So if n is a power of 3, it must divide this number
        return n > 0 and 1162261467 % n == 0


