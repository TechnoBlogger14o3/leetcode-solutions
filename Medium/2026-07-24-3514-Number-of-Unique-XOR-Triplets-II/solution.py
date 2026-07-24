class Solution:
    def uniqueTriplets(self, nums):
        unique_xors = set()
        n = len(nums)
        
        for i in range(n):
            for j in range(i, n):
                for k in range(j, n):
                    xor_value = nums[i] ^ nums[j] ^ nums[k]
                    unique_xors.add(xor_value)
        
        return len(unique_xors)

# Example usage:
# sol = Solution()
# print(sol.uniqueTriplets([1, 3]))  # Output: 2
# print(sol.uniqueTriplets([6, 7, 8, 9]))  # Output: 4