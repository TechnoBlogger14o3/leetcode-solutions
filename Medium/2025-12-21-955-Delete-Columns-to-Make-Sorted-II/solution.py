class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        m = len(strs[0])
        delete_count = 0
        sorted_indices = set()

        for col in range(m):
            for row in range(1, n):
                if col in sorted_indices:
                    break
                if strs[row][col] < strs[row - 1][col]:
                    delete_count += 1
                    sorted_indices.add(col)
                    break

        return delete_count