class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        n = len(img1)
        def count_overlap(x_offset, y_offset):
            count = 0
            for i in range(n):
                for j in range(n):
                    if 0 <= i + x_offset < n and 0 <= j + y_offset < n:
                        count += img1[i][j] * img2[i + x_offset][j + y_offset]
            return count
        
        max_overlap = 0
        for x in range(-n + 1, n):
            for y in range(-n + 1, n):
                max_overlap = max(max_overlap, count_overlap(x, y))
        
        return max_overlap