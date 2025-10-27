class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        prev_devices = 0
        total_beams = 0
        
        for row in bank:
            current_devices = row.count('1')
            if current_devices > 0:
                total_beams += prev_devices * current_devices
                prev_devices = current_devices
        
        return total_beams