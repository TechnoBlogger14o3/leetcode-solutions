class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        current_string = []

        for char in s:
            if char == '(':
                stack.append(current_string)
                current_string = []
            elif char == ')':
                current_string.reverse()
                current_string = stack.pop() + current_string
            else:
                current_string.append(char)

        return ''.join(current_string)