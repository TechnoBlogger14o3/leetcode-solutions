class Solution:
    def addBinary(self, a: str, b: str) -> str:
        max_len = max(len(a), len(b))
        a = a.zfill(max_len)
        b = b.zfill(max_len)
        
        carry = 0
        result = []
        
        for i in range(max_len - 1, -1, -1):
            total = carry + (1 if a[i] == '1' else 0) + (1 if b[i] == '1' else 0)
            result.append(str(total % 2))
            carry = total // 2
        
        if carry:
            result.append('1')
        
        return ''.join(reversed(result))