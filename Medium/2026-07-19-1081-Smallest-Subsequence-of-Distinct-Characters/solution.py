class Solution:
    def smallestSubsequence(self, s: str) -> str:
        stack = []
        seen = set()
        last_occurrence = {c: i for i, c in enumerate(s)}
        
        for i, c in enumerate(s):
            if c in seen:
                continue
            while stack and c < stack[-1] and i < last_occurrence[stack[-1]]:
                seen.remove(stack.pop())
            stack.append(c)
            seen.add(c)
        
        return ''.join(stack)