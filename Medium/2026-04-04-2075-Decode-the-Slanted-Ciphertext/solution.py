class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        if rows == 0 or not encodedText:
            return ""
        
        n = len(encodedText)
        cols = (n + rows - 1) // rows
        matrix = [[' ' for _ in range(cols)] for _ in range(rows)]
        
        idx = 0
        for r in range(rows):
            for c in range(cols):
                if idx < n:
                    matrix[r][c] = encodedText[idx]
                    idx += 1
        
        originalText = []
        for diag in range(cols):
            r, c = 0, diag
            while r < rows and c >= 0:
                if matrix[r][c] != ' ':
                    originalText.append(matrix[r][c])
                r += 1
                c -= 1
        
        return ''.join(originalText).rstrip()