class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        word = [''] * n
        
        for i in range(n):
            for j in range(n):
                if lcp[i][j] > 0:
                    if i == j:
                        if lcp[i][j] != n - i:
                            return ""
                    else:
                        if lcp[i][j] > n - max(i, j):
                            return ""
        
        for i in range(n):
            for j in range(i + 1, n):
                if lcp[i][j] > 0:
                    if word[i] == '' and word[j] == '':
                        word[i] = 'a'
                        word[j] = 'b'
                    elif word[i] == '':
                        word[i] = chr(ord(word[j]) + 1)
                    elif word[j] == '':
                        word[j] = chr(ord(word[i]) + 1)
                    elif word[i] == word[j]:
                        continue
                    else:
                        return ""
        
        for i in range(n):
            if word[i] == '':
                word[i] = 'a'
        
        for i in range(n):
            for j in range(n):
                if lcp[i][j] != self.lcp_length(word, i, j):
                    return ""
        
        return ''.join(word)
    
    def lcp_length(self, word, i, j):
        count = 0
        while i + count < len(word) and j + count < len(word) and word[i + count] == word[j + count]:
            count += 1
        return count