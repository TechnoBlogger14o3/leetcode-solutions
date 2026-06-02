class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        earliest_finish = float('inf')
        
        for i in range(len(landStartTime)):
            land_start = landStartTime[i]
            land_duration = landDuration[i]
            land_finish = land_start + land_duration
            
            for j in range(len(waterStartTime)):
                water_start = waterStartTime[j]
                water_duration = waterDuration[j]
                water_finish = water_start + water_duration
                
                # Plan A: Land ride first, then water ride
                start_water_after_land = max(land_finish, water_start)
                finish_time_A = start_water_after_land + water_duration
                
                # Plan B: Water ride first, then land ride
                start_land_after_water = max(water_finish, land_start)
                finish_time_B = start_land_after_water + land_duration
                
                earliest_finish = min(earliest_finish, finish_time_A, finish_time_B)
        
        return earliest_finish