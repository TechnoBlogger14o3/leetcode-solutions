class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        def date_to_day(date: str) -> int:
            month, day = map(int, date.split('-'))
            days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
            return sum(days_in_month[:month - 1]) + day
        
        start_alice = date_to_day(arriveAlice)
        end_alice = date_to_day(leaveAlice)
        start_bob = date_to_day(arriveBob)
        end_bob = date_to_day(leaveBob)
        
        start = max(start_alice, start_bob)
        end = min(end_alice, end_bob)
        
        return max(0, end - start + 1)