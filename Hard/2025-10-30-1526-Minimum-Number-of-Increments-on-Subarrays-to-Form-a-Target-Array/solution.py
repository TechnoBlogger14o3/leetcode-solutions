class Solution:
    def minOperations(self, target: List[int]) -> int:
        operations = 0
        for i in range(1, len(target)):
            if target[i] > target[i - 1]:
                operations += target[i] - target[i - 1]
        operations += target[0]  # Add the first element's value
        return operations