class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        m, n = len(boxGrid), len(boxGrid[0])
        result = [['.' for _ in range(m)] for _ in range(n)]
        
        for j in range(n):
            stones = 0
            for i in range(m - 1, -1, -1):
                if boxGrid[i][j] == '#':
                    stones += 1
                elif boxGrid[i][j] == '*':
                    for k in range(stones):
                        result[j][m - 1 - k] = '#'
                    result[j][m - 1 - stones] = '*'
                    stones = 0
            
            for k in range(stones):
                result[j][m - 1 - k] = '#'
        
        return result