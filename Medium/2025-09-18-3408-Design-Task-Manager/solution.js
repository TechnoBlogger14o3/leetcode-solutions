class TaskManager {
    constructor(tasks) {
        this.tasks = new Map();
        this.maxHeap = new MaxHeap();
        for (const [userId, taskId, priority] of tasks) {
            this.tasks.set(taskId, { userId, priority });
            this.maxHeap.insert({ userId, taskId, priority });
        }
    }

    add(userId, taskId, priority) {
        this.tasks.set(taskId, { userId, priority });
        this.maxHeap.insert({ userId, taskId, priority });
    }

    edit(taskId, newPriority) {
        const task = this.tasks.get(taskId);
        if (task) {
            this.tasks.set(taskId, { ...task, priority: newPriority });
            this.maxHeap.insert({ userId: task.userId, taskId, priority: newPriority });
        }
    }

    rmv(taskId) {
        this.tasks.delete(taskId);
    }

    execTop() {
        while (this.maxHeap.size() > 0) {
            const { userId, taskId, priority } = this.maxHeap.extractMax();
            if (this.tasks.has(taskId) && this.tasks.get(taskId).priority === priority) {
                this.tasks.delete(taskId);
                return userId;
            }
        }
        return -1;
    }
}

class MaxHeap {
    constructor() {
        this.heap = [];
    }

    insert(value) {
        this.heap.push(value);
        this.bubbleUp();
    }

    extractMax() {
        if (this.heap.length === 0) return null;
        const max = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this.bubbleDown();
        }
        return max;
    }

    size() {
        return this.heap.length;
    }

    bubbleUp() {
        let index = this.heap.length - 1;
        const element = this.heap[index];
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            const parent = this.heap[parentIndex];
            if (element.priority > parent.priority || (element.priority === parent.priority && element.taskId > parent.taskId)) {
                this.heap[index] = parent;
                index = parentIndex;
            } else {
                break;
            }
        }
        this.heap[index] = element;
    }

    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        const element = this.heap[0];
        while (true) {
            const leftChildIndex = 2 * index + 1;
            const rightChildIndex = 2 * index + 2;
            let leftChild, rightChild;
            let swap = null;

            if (leftChildIndex < length) {
                leftChild = this.heap[leftChildIndex];
                if (leftChild.priority > element.priority || (leftChild.priority === element.priority && leftChild.taskId > element.taskId)) {
                    swap = leftChildIndex;
                }
            }

            if (rightChildIndex < length) {
                rightChild = this.heap[rightChildIndex];
                if ((swap === null && (rightChild.priority > element.priority || (rightChild.priority === element.priority && rightChild.taskId > element.taskId))) ||
                    (swap !== null && (rightChild.priority > leftChild.priority || (rightChild.priority === leftChild.priority && rightChild.taskId > leftChild.taskId)))) {
                    swap = rightChildIndex;
                }
            }

            if (swap === null) break;
            this.heap[index] = this.heap[swap];
            index = swap;
        }
        this.heap[index] = element;
    }
}