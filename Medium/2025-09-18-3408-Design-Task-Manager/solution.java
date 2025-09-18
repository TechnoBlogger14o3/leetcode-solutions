import java.util.*;

class TaskManager {
    private final Map<Integer, Task> taskMap;
    private final PriorityQueue<Task> taskQueue;

    public TaskManager(int[][] tasks) {
        taskMap = new HashMap<>();
        taskQueue = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) {
                return Integer.compare(b.priority, a.priority);
            }
            return Integer.compare(b.taskId, a.taskId);
        });
        for (int[] task : tasks) {
            add(task[0], task[1], task[2]);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        taskMap.put(taskId, newTask);
        taskQueue.offer(newTask);
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            taskQueue.remove(task);
            task.priority = newPriority;
            taskQueue.offer(task);
        }
    }

    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        if (task != null) {
            taskQueue.remove(task);
        }
    }

    public int execTop() {
        while (!taskQueue.isEmpty()) {
            Task topTask = taskQueue.poll();
            if (topTask != null && taskMap.containsKey(topTask.taskId)) {
                taskMap.remove(topTask.taskId);
                return topTask.userId;
            }
        }
        return -1;
    }

    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
}