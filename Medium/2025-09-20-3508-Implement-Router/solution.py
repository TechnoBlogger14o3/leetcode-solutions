from collections import deque

class Router:
    def __init__(self, memoryLimit: int):
        self.memoryLimit = memoryLimit
        self.packets = deque()
        self.packet_set = set()

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        packet = (source, destination, timestamp)
        if packet in self.packet_set:
            return False
        if len(self.packets) >= self.memoryLimit:
            oldest_packet = self.packets.popleft()
            self.packet_set.remove(oldest_packet)
        self.packets.append(packet)
        self.packet_set.add(packet)
        return True

    def forwardPacket(self) -> list:
        if not self.packets:
            return []
        packet = self.packets.popleft()
        self.packet_set.remove(packet)
        return list(packet)

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        count = 0
        for packet in self.packets:
            if packet[1] == destination and startTime <= packet[2] <= endTime:
                count += 1
        return count