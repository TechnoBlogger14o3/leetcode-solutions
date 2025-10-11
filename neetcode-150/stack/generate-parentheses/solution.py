"""
Time Complexity: O(4^n / √n) - Catalan number
Space Complexity: O(n) - Recursion depth
"""
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self.backtrack(result, "", 0, 0, n)
        return result
    
    def backtrack(self, result, current, open_count, close_count, n):
        if open_count == n and close_count == n:
            result.append(current)
            return
        
        if open_count < n:
            self.backtrack(result, current + "(", open_count + 1, close_count, n)
        
        if close_count < open_count:
            self.backtrack(result, current + ")", open_count, close_count + 1, n)

# Alternative approach using iterative method
class SolutionIterative:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        queue = [""]
        
        while queue:
            current = queue.pop(0)
            open_count = current.count('(')
            close_count = current.count(')')
            
            if open_count == n and close_count == n:
                result.append(current)
            else:
                if open_count < n:
                    queue.append(current + "(")
                if close_count < open_count:
                    queue.append(current + ")")
        
        return result

# More concise version
class SolutionConcise:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        
        def generate(s, open_count, close_count):
            if len(s) == 2 * n:
                result.append(s)
                return
            
            if open_count < n:
                generate(s + "(", open_count + 1, close_count)
            if close_count < open_count:
                generate(s + ")", open_count, close_count + 1)
        
        generate("", 0, 0)
        return result

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return [""]
        
        result = []
        for i in range(n):
            for left in self.generateParenthesis(i):
                for right in self.generateParenthesis(n - 1 - i):
                    result.append(f"({left}){right}")
        
        return result

# Using yield for memory efficiency
class SolutionYield:
    def generateParenthesis(self, n: int) -> List[str]:
        def generate(s, open_count, close_count):
            if len(s) == 2 * n:
                yield s
                return
            
            if open_count < n:
                yield from generate(s + "(", open_count + 1, close_count)
            if close_count < open_count:
                yield from generate(s + ")", open_count, close_count + 1)
        
        return list(generate("", 0, 0))
