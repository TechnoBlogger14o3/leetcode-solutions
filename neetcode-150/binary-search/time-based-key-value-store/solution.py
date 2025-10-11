"""
Time Complexity: O(log n) for get, O(1) for set
Space Complexity: O(n) - Store all key-value pairs
"""
class TimeMap:
    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map or not self.map[key]:
            return ""
        
        list_ = self.map[key]
        left = 0
        right = len(list_) - 1
        result = -1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if list_[mid][0] <= timestamp:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return "" if result == -1 else list_[result][1]

# Alternative approach using defaultdict
from collections import defaultdict

class TimeMapDefaultDict:
    def __init__(self):
        self.map = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map or not self.map[key]:
            return ""
        
        list_ = self.map[key]
        left = 0
        right = len(list_) - 1
        result = -1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if list_[mid][0] <= timestamp:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return "" if result == -1 else list_[result][1]

# Alternative approach using bisect
import bisect

class TimeMapBisect:
    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map or not self.map[key]:
            return ""
        
        list_ = self.map[key]
        # Find the rightmost position where timestamp <= target
        index = bisect.bisect_right(list_, [timestamp, ""]) - 1
        
        return "" if index < 0 else list_[index][1]

# More concise version
class TimeMapConcise:
    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map:
            return ""
        
        list_ = self.map[key]
        left, right, result = 0, len(list_) - 1, -1
        
        while left <= right:
            mid = (left + right) // 2
            if list_[mid][0] <= timestamp:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return "" if result == -1 else list_[result][1]

# Using dataclass for cleaner code
from dataclasses import dataclass
from typing import List, Optional

@dataclass
class TimeValue:
    timestamp: int
    value: str

class TimeMapDataClass:
    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append(TimeValue(timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map or not self.map[key]:
            return ""
        
        list_ = self.map[key]
        left, right, result = 0, len(list_) - 1, -1
        
        while left <= right:
            mid = (left + right) // 2
            if list_[mid].timestamp <= timestamp:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return "" if result == -1 else list_[result].value
