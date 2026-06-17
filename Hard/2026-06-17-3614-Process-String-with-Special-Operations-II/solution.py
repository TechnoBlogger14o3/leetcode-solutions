class Solution:
    def processString(self, s: str, k: int) -> str:
        result = []
        length = 0
        
        for char in s:
            if char.islower():
                result.append(char)
                length += 1
            elif char == '*':
                if length > 0:
                    result.pop()
                    length -= 1
            elif char == '#':
                result.extend(result)
                length *= 2
            elif char == '%':
                result.reverse()
        
        if k >= length:
            return '.'
        return result[k]