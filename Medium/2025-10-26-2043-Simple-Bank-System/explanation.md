# Simple Bank System (Medium)

**Problem ID:** 2043  
**Date:** 2025-10-26  
**Link:** https://leetcode.com/problems/simple-bank-system/

## Approach

To solve the "Simple Bank System" problem, we need to implement a `Bank` class that manages multiple bank accounts and processes transactions such as deposits, withdrawals, and transfers. Here’s a structured approach to tackle the problem:

### Main Idea
The main idea is to maintain an array that represents the balance of each bank account. We will implement methods to perform the required operations while ensuring that each transaction adheres to the specified validity conditions.

### Data Structures
1. **Array**: We will use a 0-indexed array `balance` to store the balance of each account, where the index corresponds to the account number minus one (since account numbers are 1-indexed).
2. **Methods**: The class will have three primary methods:
   - `deposit(account, money)`: Increases the balance of the specified account.
   - `withdraw(account, money)`: Decreases the balance of the specified account if sufficient funds exist.
   - `transfer(account1, account2, money)`: Transfers money from one account to another if both accounts are valid and the source account has enough balance.

### Approach
1. **Initialization**: The constructor `Bank(long[] balance)` initializes the account balances using the provided array.
2. **Transaction Validity Checks**:
   - For each transaction (withdraw, deposit, transfer), first check if the account number is valid (i.e., between 1 and n).
   - For withdrawals and transfers, check if the account has sufficient funds before proceeding.
3. **Performing Transactions**:
   - For deposits, simply add the specified amount to the account's balance.
   - For withdrawals, subtract the amount from the account's balance if valid.
   - For transfers, subtract the amount from the source account and add it to the destination account if both accounts are valid and the source has enough funds.

### Complexity Analysis
- **Time Complexity**: Each transaction (withdraw, deposit, transfer) operates in O(1) time since it involves simple arithmetic and array indexing.
- **Space Complexity**: The space complexity is O(n) due to the storage of the balance array, where n is the number of accounts.

### Conclusion
This approach efficiently manages the bank accounts and transactions while ensuring all operations are valid. The use of an array allows for quick access and updates, making the solution optimal for the given constraints.
