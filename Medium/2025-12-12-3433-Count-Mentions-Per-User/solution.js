var countMentions = function(numberOfUsers, events) {
    const mentions = new Array(numberOfUsers).fill(0);
    const onlineStatus = new Array(numberOfUsers).fill(true);
    const offlineUntil = new Array(numberOfUsers).fill(0);

    for (const event of events) {
        const [type, timestampStr, data] = event;
        const timestamp = parseInt(timestampStr);

        // Update online status based on offline events
        for (let i = 0; i < numberOfUsers; i++) {
            if (!onlineStatus[i] && offlineUntil[i] <= timestamp) {
                onlineStatus[i] = true;
            }
        }

        if (type === "OFFLINE") {
            const userId = parseInt(data.slice(2)); // Extract user id from "id<number>"
            onlineStatus[userId] = false;
            offlineUntil[userId] = timestamp + 60;
        } else if (type === "MESSAGE") {
            const mentionsString = data.split(" ");
            const mentionedUsers = new Set();

            for (const mention of mentionsString) {
                if (mention === "ALL") {
                    for (let i = 0; i < numberOfUsers; i++) {
                        mentionedUsers.add(i);
                    }
                } else if (mention === "HERE") {
                    for (let i = 0; i < numberOfUsers; i++) {
                        if (onlineStatus[i]) {
                            mentionedUsers.add(i);
                        }
                    }
                } else if (mention.startsWith("id")) {
                    const userId = parseInt(mention.slice(2));
                    mentionedUsers.add(userId);
                }
            }

            for (const userId of mentionedUsers) {
                mentions[userId] += 1;
            }
        }
    }

    return mentions;
};