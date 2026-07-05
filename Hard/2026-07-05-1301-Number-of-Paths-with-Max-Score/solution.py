class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n = len(board)
        MOD = 10**9 + 7
        
        # Initialize dp arrays
        dp = [[0] * n for _ in range(n)]
        count = [[0] * n for _ in range(n)]
        
        # Start from the bottom-right corner
        dp[n-1][n-1] = 0 if board[n-1][n-1] == 'S' else int(board[n-1][n-1])
        count[n-1][n-1] = 1 if board[n-1][n-1] == 'S' else 0
        
        # Fill the dp and count arrays
        for i in range(n-1, -1, -1):
            for j in range(n-1, -1, -1):
                if board[i][j] == 'X' or (i == n-1 and j == n-1):
                    continue
                
                if i < n-1:
                    if dp[i][j] < dp[i+1][j] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        dp[i][j] = dp[i+1][j] + (int(board[i][j]) if board[i][j].isdigit() else 0)
                        count[i][j] = count[i+1][j]
                    elif dp[i][j] == dp[i+1][j] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        count[i][j] = (count[i][j] + count[i+1][j]) % MOD
                
                if j < n-1:
                    if dp[i][j] < dp[i][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        dp[i][j] = dp[i][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0)
                        count[i][j] = count[i][j+1]
                    elif dp[i][j] == dp[i][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        count[i][j] = (count[i][j] + count[i][j+1]) % MOD
                
                if i < n-1 and j < n-1:
                    if dp[i][j] < dp[i+1][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        dp[i][j] = dp[i+1][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0)
                        count[i][j] = count[i+1][j+1]
                    elif dp[i][j] == dp[i+1][j+1] + (int(board[i][j]) if board[i][j].isdigit() else 0):
                        count[i][j] = (count[i][j] + count[i+1][j+1]) % MOD
        
        max_score = dp[0][0]
        num_paths = count[0][0]
        
        if max_score == 0:
            return [0, 0]
        
        return [max_score, num_paths]