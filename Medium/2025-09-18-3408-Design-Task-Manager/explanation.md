# Design Task Manager (Medium)

**Problem ID:** 3408  
**Date:** 2025-09-18  
**Link:** https://leetcode.com/problems/design-task-manager/

## Approach

To solve the "Design Task Manager" problem, we need to efficiently manage tasks associated with users, each having a priority. The core operations we need to support are adding, editing, removing, and executing tasks based on their priority and task ID.

### Main Idea:
The main idea is to utilize a priority queue (or max-heap) to keep track of tasks based on their priorities. This allows us to efficiently retrieve and execute the task with the highest priority. If multiple tasks share the same priority, we will use the task ID to break ties, ensuring that the task with the higher ID is executed first.

### Data Structures:
1. **Priority Queue (Max-Heap)**: This will store tasks in the format `(priority, taskId, userId)`. The priority queue will allow us to efficiently access and remove the task with the highest priority.
2. **Hash Map (Dictionary)**: This will map `taskId` to a tuple `(priority, userId)` for quick access to task details when editing or removing tasks. This ensures that we can efficiently update the priority or remove a task without needing to search through the priority queue.

### Operations:
1. **Initialization**: Populate the priority queue and hash map with the initial list of tasks.
2. **Add Task**: Insert the new task into the priority queue and hash map.
3. **Edit Task**: Update the task's priority in the hash map, and reinsert it into the priority queue to maintain the correct order.
4. **Remove Task**: Remove the task from the hash map. To ensure consistency in the priority queue, we can mark the task as removed and handle its removal lazily during the `execTop` operation.
5. **Execute Top Task**: Continuously extract the top task from the priority queue until we find a task that is still valid (not marked for removal). Return the `userId` of the executed task and remove it from the hash map.

### Complexity:
- **Time Complexity**:
  - Adding a task: O(log n) for insertion into the priority queue.
  - Editing a task: O(log n) for reinserting into the priority queue after updating the hash map.
  - Removing a task: O(1) for updating the hash map, but O(log n) for cleaning up the priority queue during execution.
  - Executing the top task: O(log n) for each extraction from the priority queue, but may involve multiple extractions in the worst case if many tasks are marked as removed.
  
- **Space Complexity**: O(n) for storing tasks in both the priority queue and hash map.

This approach ensures that all operations are efficient and can handle the constraints provided in the problem statement. By leveraging a combination of a priority queue and a hash map, we achieve both fast access and priority management for the tasks.
