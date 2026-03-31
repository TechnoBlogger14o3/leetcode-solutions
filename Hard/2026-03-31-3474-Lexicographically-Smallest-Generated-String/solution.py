class Solution:
    def smallestString(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)
        word = [''] * (n + m - 1)
        
        for i in range(n):
            if str1[i] == 'T':
                if i + m - 1 >= len(word):
                    return ""
                for j in range(m):
                    if word[i + j] == '':
                        word[i + j] = str2[j]
                    elif word[i + j] != str2[j]:
                        return ""
            else:
                if i + m - 1 < len(word):
                    for j in range(m):
                        if word[i + j] == '':
                            continue
                        if word[i + j] == str2[j]:
                            return ""
        
        for i in range(len(word)):
            if word[i] == '':
                word[i] = 'a'
        
        return ''.join(word)