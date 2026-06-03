class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        min_finish_time = float('inf')
        
        for i in range(len(landStartTime)):
            land_start = landStartTime[i]
            land_duration = landDuration[i]
            land_finish = land_start + land_duration
            
            for j in range(len(waterStartTime)):
                water_start = waterStartTime[j]
                water_duration = waterDuration[j]
                water_finish = water_start + water_duration
                
                # Plan A: Land ride first, then water ride
                start_water_after_land = max(water_start, land_finish)
                finish_time_a = start_water_after_land + water_duration
                
                # Plan B: Water ride first, then land ride
                start_land_after_water = max(land_start, water_finish)
                finish_time_b = start_land_after_water + land_duration
                
                min_finish_time = min(min_finish_time, finish_time_a, finish_time_b)
        
        return min_finish_time