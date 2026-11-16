class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while len(s) > k:
            groups = [s[i:i + k] for i in range(0, len(s), k)]
            s = ''.join(str(sum(int(char) for char in group)) for group in groups)
        return s