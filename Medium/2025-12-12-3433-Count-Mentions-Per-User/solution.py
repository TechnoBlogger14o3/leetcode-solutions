class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        mentions = [0] * numberOfUsers
        online = [True] * numberOfUsers
        offline_until = [-1] * numberOfUsers
        
        for event in events:
            event_type, timestamp, detail = event
            
            if event_type == "OFFLINE":
                user_id = int(detail)
                online[user_id] = False
                offline_until[user_id] = int(timestamp) + 60
            
            elif event_type == "MESSAGE":
                current_time = int(timestamp)
                for user_id in range(numberOfUsers):
                    if not online[user_id] and current_time < offline_until[user_id]:
                        continue
                
                if detail == "ALL":
                    for user_id in range(numberOfUsers):
                        mentions[user_id] += 1
                elif detail == "HERE":
                    for user_id in range(numberOfUsers):
                        if online[user_id]:
                            mentions[user_id] += 1
                else:
                    mentioned_users = detail.split()
                    for mention in mentioned_users:
                        if mention.startswith("id"):
                            user_id = int(mention[2:])
                            mentions[user_id] += 1
        
        return mentions