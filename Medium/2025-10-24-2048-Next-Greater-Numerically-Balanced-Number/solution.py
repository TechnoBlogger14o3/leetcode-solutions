class Solution:
    def nextGreaterBalanced(self, n: int) -> int:
        def is_balanced(num):
            count = {}
            for digit in str(num):
                count[digit] = count.get(digit, 0) + 1
            for digit, cnt in count.items():
                if int(digit) != cnt:
                    return False
            return True

        n += 1
        while True:
            if is_balanced(n):
                return n
            n += 1