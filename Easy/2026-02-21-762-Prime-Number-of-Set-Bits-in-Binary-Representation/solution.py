class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        def is_prime(n):
            if n < 2:
                return False
            for i in range(2, int(n**0.5) + 1):
                if n % i == 0:
                    return False
            return True
        
        prime_set_bits_count = sum(is_prime(bin(i).count('1')) for i in range(left, right + 1))
        return prime_set_bits_count