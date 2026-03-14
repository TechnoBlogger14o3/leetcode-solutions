class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        def backtrack(current: str):
            if len(current) == n:
                happy_strings.append(current)
                return
            for char in 'abc':
                if not current or current[-1] != char:
                    backtrack(current + char)

        happy_strings = []
        backtrack("")
        return happy_strings[k - 1] if k <= len(happy_strings) else ""