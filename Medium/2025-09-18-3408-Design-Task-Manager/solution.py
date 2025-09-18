import heapq

class TaskManager:
    def __init__(self, tasks):
        self.tasks = {}
        self.heap = []
        for userId, taskId, priority in tasks:
            self.tasks[taskId] = (userId, priority)
            heapq.heappush(self.heap, (-priority, -taskId, taskId))

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.tasks[taskId] = (userId, priority)
        heapq.heappush(self.heap, (-priority, -taskId, taskId))

    def edit(self, taskId: int, newPriority: int) -> None:
        userId, _ = self.tasks[taskId]
        self.tasks[taskId] = (userId, newPriority)
        heapq.heappush(self.heap, (-newPriority, -taskId, taskId))

    def rmv(self, taskId: int) -> None:
        del self.tasks[taskId]

    def execTop(self) -> int:
        while self.heap:
            priority, negTaskId, taskId = heapq.heappop(self.heap)
            if taskId in self.tasks and self.tasks[taskId][1] == -priority:
                del self.tasks[taskId]
                return self.tasks[taskId][0]
        return -1