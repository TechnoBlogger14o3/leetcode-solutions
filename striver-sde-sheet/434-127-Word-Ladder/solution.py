from collections import deque
from typing import List

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        wordSet = set(wordList)
        queue = deque([(beginWord, 1)])
        visited = {beginWord}
        
        while queue:
            word, length = queue.popleft()
            
            if word == endWord:
                return length
            
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    newWord = word[:i] + c + word[i+1:]
                    if newWord in wordSet and newWord not in visited:
                        visited.add(newWord)
                        queue.append((newWord, length + 1))
        
        return 0
