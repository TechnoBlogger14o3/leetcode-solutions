# Minimum Initial Energy to Finish Tasks (Hard)

**Problem ID:** 1665  
**Date:** 2026-05-12  
**Link:** https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/

## Approach

To solve the problem of determining the minimum initial energy required to finish all tasks, we can adopt the following approach:

### Main Idea:
The core idea is to strategically order the tasks based on their energy requirements to ensure that we can complete all tasks with the least initial energy. Specifically, we need to consider both the actual energy cost of completing a task and the minimum energy required to start that task.

### Steps:
1. **Sort the Tasks**: First, sort the tasks based on their minimum energy requirement (`minimum_i`). This ensures that we always consider tasks that we must be able to start first. If we can complete a task with a higher minimum energy requirement earlier, we can potentially reduce the initial energy needed.

2. **Simulate Task Completion**: Initialize a variable to track the current energy and another to determine the minimum initial energy needed. Iterate through the sorted list of tasks:
   - For each task, check if the current energy is sufficient to start the task (i.e., `current_energy >= minimum_i`).
   - If it is not sufficient, calculate how much additional energy is needed to start the task and adjust the minimum initial energy accordingly.
   - After completing the task, reduce the current energy by the actual energy cost (`actual_i`).

3. **Final Calculation**: At the end of the iteration, the tracked minimum initial energy will represent the least energy needed to start and finish all tasks.

### Data Structures:
- An array or list to store the tasks.
- A simple integer variable to track `current_energy`.
- Another integer variable to track `min_initial_energy`.

### Complexity:
- **Time Complexity**: O(n log n) due to the sorting step, where `n` is the number of tasks.
- **Space Complexity**: O(1) for the additional variables used, assuming the input tasks are modified in place.

This approach guarantees that we account for the constraints of each task effectively while minimizing the initial energy needed to complete all tasks. By sorting and simulating the task completion, we can ensure that we always have enough energy to proceed with the next task.
