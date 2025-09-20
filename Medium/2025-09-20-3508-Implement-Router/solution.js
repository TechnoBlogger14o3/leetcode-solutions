class Router {
    constructor(memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new Map();
        this.queue = [];
    }

    addPacket(source, destination, timestamp) {
        const key = `${source},${destination},${timestamp}`;
        if (this.packets.has(key)) {
            return false;
        }
        if (this.queue.length >= this.memoryLimit) {
            const oldest = this.queue.shift();
            this.packets.delete(oldest);
        }
        const packet = [source, destination, timestamp];
        this.queue.push(key);
        this.packets.set(key, packet);
        return true;
    }

    forwardPacket() {
        if (this.queue.length === 0) {
            return [];
        }
        const oldestKey = this.queue.shift();
        const packet = this.packets.get(oldestKey);
        this.packets.delete(oldestKey);
        return packet;
    }

    getCount(destination, startTime, endTime) {
        let count = 0;
        for (const key of this.queue) {
            const [source, dest, timestamp] = this.packets.get(key);
            if (dest === destination && timestamp >= startTime && timestamp <= endTime) {
                count++;
            }
        }
        return count;
    }
}