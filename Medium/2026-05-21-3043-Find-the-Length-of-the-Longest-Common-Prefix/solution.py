class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        def common_prefix_length(x: int, y: int) -> int:
            str_x, str_y = str(x), str(y)
            min_length = min(len(str_x), len(str_y))
            for i in range(min_length):
                if str_x[i] != str_y[i]:
                    return i
            return min_length
        
        max_length = 0
        for x in arr1:
            for y in arr2:
                max_length = max(max_length, common_prefix_length(x, y))
        
        return max_length