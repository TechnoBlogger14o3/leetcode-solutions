from itertools import permutations

class Solution:
    def distinctEvenNumbers(self, digits):
        unique_numbers = set()
        for perm in permutations(digits, 3):
            if perm[0] != 0 and perm[2] % 2 == 0:
                unique_numbers.add(perm)
        return len(unique_numbers)

# Example usage:
# sol = Solution()
# print(sol.distinctEvenNumbers([1,2,3,4]))  # Output: 12
# print(sol.distinctEvenNumbers([0,2,2]))    # Output: 2
# print(sol.distinctEvenNumbers([6,6,6]))    # Output: 1
# print(sol.distinctEvenNumbers([1,3,5]))    # Output: 0