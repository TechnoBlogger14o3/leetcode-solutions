class Solution:
    def maxPalindromes(self, s: str, k: int) -> int:
        n = len(s)
        dp = [0] * (n + 1)
        palindromes = []

        # Function to check for palindromes
        def add_palindromes(l: int, r: int):
            while l >= 0 and r < n and s[l] == s[r]:
                if r - l + 1 >= k:
                    palindromes.append((l, r))
                l -= 1
                r += 1

        # Find all palindromes
        for i in range(n):
            add_palindromes(i, i)     # Odd length palindromes
            add_palindromes(i, i + 1) # Even length palindromes

        # Sort palindromes by their end index
        palindromes.sort(key=lambda x: x[1])

        count = 0
        last_end = -1

        for start, end in palindromes:
            if start > last_end:
                count += 1
                last_end = end

        return count