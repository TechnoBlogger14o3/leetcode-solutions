"""
Time Complexity: O(n) - Single pass through tokens
Space Complexity: O(n) - Stack can hold all operands
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token in '+-*/':
                b = stack.pop()
                a = stack.pop()
                if token == '+':
                    stack.append(a + b)
                elif token == '-':
                    stack.append(a - b)
                elif token == '*':
                    stack.append(a * b)
                elif token == '/':
                    stack.append(int(a / b))  # Truncate towards zero
            else:
                stack.append(int(token))
        
        return stack[0]

# Alternative approach using dictionary
class SolutionDict:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operations = {
            '+': lambda a, b: a + b,
            '-': lambda a, b: a - b,
            '*': lambda a, b: a * b,
            '/': lambda a, b: int(a / b)
        }
        
        for token in tokens:
            if token in operations:
                b = stack.pop()
                a = stack.pop()
                stack.append(operations[token](a, b))
            else:
                stack.append(int(token))
        
        return stack[0]

# More concise version
class SolutionConcise:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token == '+':
                stack.append(stack.pop() + stack.pop())
            elif token == '-':
                b = stack.pop()
                a = stack.pop()
                stack.append(a - b)
            elif token == '*':
                stack.append(stack.pop() * stack.pop())
            elif token == '/':
                b = stack.pop()
                a = stack.pop()
                stack.append(int(a / b))
            else:
                stack.append(int(token))
        
        return stack[0]

# Using operator module
import operator

class SolutionOperator:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operations = {
            '+': operator.add,
            '-': operator.sub,
            '*': operator.mul,
            '/': lambda a, b: int(a / b)
        }
        
        for token in tokens:
            if token in operations:
                b = stack.pop()
                a = stack.pop()
                stack.append(operations[token](a, b))
            else:
                stack.append(int(token))
        
        return stack[0]

# Using deque for better performance
from collections import deque

class SolutionDeque:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = deque()
        
        for token in tokens:
            if token in '+-*/':
                b = stack.pop()
                a = stack.pop()
                if token == '+':
                    stack.append(a + b)
                elif token == '-':
                    stack.append(a - b)
                elif token == '*':
                    stack.append(a * b)
                elif token == '/':
                    stack.append(int(a / b))
            else:
                stack.append(int(token))
        
        return stack[0]
