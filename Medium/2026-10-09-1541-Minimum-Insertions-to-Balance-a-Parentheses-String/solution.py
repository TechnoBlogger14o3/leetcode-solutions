class Solution:
    def minInsertions(self, s: str) -> int:
        balance = 0
        insertions = 0
        
        i = 0
        while i < len(s):
            if s[i] == '(':
                balance += 1
                i += 1
            else:
                if i + 1 < len(s) and s[i + 1] == ')':
                    i += 2
                else:
                    insertions += 1
                    i += 1
                
                if balance > 0:
                    balance -= 1
                else:
                    insertions += 1
        
        insertions += balance * 2
        return insertions