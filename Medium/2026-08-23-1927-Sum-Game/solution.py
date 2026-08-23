class Solution:
    def sumGame(self, num: str) -> bool:
        n = len(num) // 2
        left_sum = 0
        right_sum = 0
        left_question = 0
        right_question = 0
        
        for i in range(n):
            if num[i] == '?':
                left_question += 1
            else:
                left_sum += int(num[i])
        
        for i in range(n, len(num)):
            if num[i] == '?':
                right_question += 1
            else:
                right_sum += int(num[i])
        
        total_question = left_question + right_question
        diff = left_sum - right_sum
        
        if total_question == 0:
            return diff != 0
        
        if diff < 0:
            diff = -diff
        
        if diff % 2 == 0:
            needed = diff // 2
        else:
            needed = (diff // 2) + 1
        
        return needed > right_question * 9 or needed > left_question * 9