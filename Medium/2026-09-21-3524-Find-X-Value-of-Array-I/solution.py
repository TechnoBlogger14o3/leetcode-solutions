class Solution:
    def findXValue(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = [0] * k
        prefix_product = [1] * (n + 1)
        suffix_product = [1] * (n + 1)

        for i in range(n):
            prefix_product[i + 1] = (prefix_product[i] * nums[i]) % k

        for i in range(n - 1, -1, -1):
            suffix_product[i] = (suffix_product[i + 1] * nums[i]) % k

        for i in range(n + 1):
            for j in range(i, n + 1):
                product = (prefix_product[i] * suffix_product[j]) % k
                result[product] += 1

        return result