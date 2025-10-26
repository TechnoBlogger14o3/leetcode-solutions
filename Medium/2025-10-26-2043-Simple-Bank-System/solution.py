class Bank:

    def __init__(self, balance: List[int]):
        self.balance = balance

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        if 1 <= account1 <= len(self.balance) and 1 <= account2 <= len(self.balance):
            if self.balance[account1 - 1] >= money:
                self.balance[account1 - 1] -= money
                self.balance[account2 - 1] += money
                return True
        return False

    def deposit(self, account: int, money: int) -> bool:
        if 1 <= account <= len(self.balance):
            self.balance[account - 1] += money
            return True
        return False

    def withdraw(self, account: int, money: int) -> bool:
        if 1 <= account <= len(self.balance):
            if self.balance[account - 1] >= money:
                self.balance[account - 1] -= money
                return True
        return False