from functools import lru_cache

class Solution:
    def soupServings(self, n: int) -> float:
        # For large n, probability approaches 1.0
        if n >= 5000:
            return 1.0
        
        # Convert to units of 25ml for efficiency
        units = (n + 24) // 25  # Ceiling division
        
        @lru_cache(maxsize=None)
        def solve(a: int, b: int) -> float:
            # Base cases
            if a <= 0 and b <= 0:
                return 0.5  # Both empty
            if a <= 0:
                return 1.0  # A empty first
            if b <= 0:
                return 0.0  # B empty first
            
            # Four operations with equal probability
            return 0.25 * (
                solve(a - 4, b) +      # Serve 100ml A, 0ml B
                solve(a - 3, b - 1) +  # Serve 75ml A, 25ml B
                solve(a - 2, b - 2) +  # Serve 50ml A, 50ml B
                solve(a - 1, b - 3)    # Serve 25ml A, 75ml B
            )
        
        return solve(units, units)