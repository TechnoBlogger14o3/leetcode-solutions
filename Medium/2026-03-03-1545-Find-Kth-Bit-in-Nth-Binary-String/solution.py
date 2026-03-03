class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def generate_s(n):
            if n == 1:
                return "0"
            s_prev = generate_s(n - 1)
            inverted = ''.join('1' if x == '0' else '0' for x in reversed(s_prev))
            return s_prev + '1' + inverted
        
        s_n = generate_s(n)
        return s_n[k - 1]

# Example usage:
# sol = Solution()
# print(sol.findKthBit(3, 1))  # Output: "0"
# print(sol.findKthBit(4, 11)) # Output: "1"