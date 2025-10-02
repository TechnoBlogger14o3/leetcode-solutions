class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        total_drunk = 0
        empty_bottles = 0
        
        while numBottles > 0:
            total_drunk += numBottles
            empty_bottles += numBottles
            numBottles = empty_bottles // numExchange
            empty_bottles %= numExchange
        
        return total_drunk