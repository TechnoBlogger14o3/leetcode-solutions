class Solution:
    def countSubstrings(self, patterns: List[str], word: str) -> int:
        return sum(1 for pattern in patterns if pattern in word)