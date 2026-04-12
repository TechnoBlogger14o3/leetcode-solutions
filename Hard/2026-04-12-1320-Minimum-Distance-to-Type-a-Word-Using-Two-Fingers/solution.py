class Solution:
    def minimumDistance(self, word: str) -> int:
        # Keyboard layout coordinates
        keyboard = {chr(i): (i // 6, i % 6) for i in range(ord('A'), ord('Z') + 1)}
        
        n = len(word)
        dp = [[[float('inf')] * 26 for _ in range(26)] for _ in range(n + 1)]
        
        # Initial positions of fingers are free
        for i in range(26):
            dp[0][i][i] = 0
        
        for i in range(1, n + 1):
            curr_char = word[i - 1]
            curr_x, curr_y = keyboard[curr_char]
            for j in range(26):
                for k in range(26):
                    # Move finger 1 to current character
                    dp[i][ord(curr_char) - ord('A')][k] = min(dp[i][ord(curr_char) - ord('A')][k], 
                                                                dp[i - 1][j][k] + (abs(curr_x - keyboard[chr(j + ord('A'))][0]) + 
                                                                                   abs(curr_y - keyboard[chr(j + ord('A'))][1])))
                    # Move finger 2 to current character
                    dp[i][j][ord(curr_char) - ord('A')] = min(dp[i][j][ord(curr_char) - ord('A')], 
                                                                dp[i - 1][j][k] + (abs(curr_x - keyboard[chr(k + ord('A'))][0]) + 
                                                                                   abs(curr_y - keyboard[chr(k + ord('A'))][1])))
        
        return min(dp[n][j][k] for j in range(26) for k in range(26))