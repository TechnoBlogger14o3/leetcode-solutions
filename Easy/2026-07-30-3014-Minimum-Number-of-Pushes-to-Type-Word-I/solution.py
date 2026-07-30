class Solution:
    def minimumPushes(self, word: str) -> int:
        n = len(word)
        # Each letter can be assigned to a key with a maximum of 3 letters per key
        pushes = 0
        for i in range(n):
            pushes += (i // 3) + 1
        return pushes