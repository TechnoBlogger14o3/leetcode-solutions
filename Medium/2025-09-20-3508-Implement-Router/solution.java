import java.util.*;

class Router {
    private final int memoryLimit;
    private final Queue<int[]> packetQueue;
    private final Set<String> packetSet;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packetQueue = new LinkedList<>();
        this.packetSet = new HashSet<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        if (packetSet.contains(key)) {
            return false;
        }
        if (packetQueue.size() >= memoryLimit) {
            int[] oldestPacket = packetQueue.poll();
            String oldestKey = oldestPacket[0] + "," + oldestPacket[1] + "," + oldestPacket[2];
            packetSet.remove(oldestKey);
        }
        int[] newPacket = new int[]{source, destination, timestamp};
        packetQueue.offer(newPacket);
        packetSet.add(key);
        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[0];
        }
        int[] packet = packetQueue.poll();
        String key = packet[0] + "," + packet[1] + "," + packet[2];
        packetSet.remove(key);
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for (int[] packet : packetQueue) {
            if (packet[1] == destination && packet[2] >= startTime && packet[2] <= endTime) {
                count++;
            }
        }
        return count;
    }
}