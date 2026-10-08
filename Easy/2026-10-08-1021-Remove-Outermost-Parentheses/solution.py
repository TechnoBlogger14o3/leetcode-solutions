class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        count = 0
        result = []
        
        for char in s:
            if char == '(':
                if count > 0:
                    result.append(char)
                count += 1
            else:
                count -= 1
                if count > 0:
                    result.append(char)
        
        return ''.join(result)