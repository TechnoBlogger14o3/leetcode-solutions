"""
Time Complexity: O(n) - Single pass through string
Space Complexity: O(n) - Stack can hold up to n characters
"""
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        for c in s:
            if c in '({[':
                stack.append(c)
            else:
                if not stack:
                    return False
                
                top = stack.pop()
                if (c == ')' and top != '(') or \
                   (c == '}' and top != '{') or \
                   (c == ']' and top != '['):
                    return False
        
        return len(stack) == 0

# Alternative approach using dictionary
class SolutionDict:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {')': '(', '}': '{', ']': '['}
        
        for c in s:
            if c in pairs:
                if not stack or stack.pop() != pairs[c]:
                    return False
            else:
                stack.append(c)
        
        return len(stack) == 0

# More concise version
class SolutionConcise:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(':
                stack.append(')')
            elif c == '{':
                stack.append('}')
            elif c == '[':
                stack.append(']')
            elif not stack or stack.pop() != c:
                return False
        return len(stack) == 0

# Using deque for better performance
from collections import deque

class SolutionDeque:
    def isValid(self, s: str) -> bool:
        stack = deque()
        
        for c in s:
            if c in '({[':
                stack.append(c)
            else:
                if not stack:
                    return False
                
                top = stack.pop()
                if (c == ')' and top != '(') or \
                   (c == '}' and top != '{') or \
                   (c == ']' and top != '['):
                    return False
        
        return len(stack) == 0

# One-liner approach (not recommended for readability)
class SolutionOneLiner:
    def isValid(self, s: str) -> bool:
        while '()' in s or '{}' in s or '[]' in s:
            s = s.replace('()', '').replace('{}', '').replace('[]', '')
        return s == ''
