class MeetingRoomsIII {
    static mostBooked(n, meetings) {
        meetings.sort((a, b) => a[0] - b[0]);
        const roomEndTimes = new Array(n).fill(0);
        const roomMeetingCounts = new Array(n).fill(0);
        const waitingMeetings = [];

        for (const [start, end] of meetings) {
            while (waitingMeetings.length && roomEndTimes[waitingMeetings[0].room] <= start) {
                const { room, duration } = waitingMeetings.shift();
                roomEndTimes[room] = start + duration;
                roomMeetingCounts[room]++;
            }

            let room = -1;
            for (let i = 0; i < n; i++) {
                if (roomEndTimes[i] <= start) {
                    room = i;
                    break;
                }
            }

            if (room === -1) {
                const nextMeeting = Math.min(...roomEndTimes);
                const nextRoom = roomEndTimes.indexOf(nextMeeting);
                waitingMeetings.push({ room: nextRoom, duration: end - start });
                roomEndTimes[nextRoom] = nextMeeting + (end - start);
            } else {
                roomEndTimes[room] = end;
                roomMeetingCounts[room]++;
            }
        }

        let maxMeetings = -1;
        let roomWithMaxMeetings = -1;

        for (let i = 0; i < n; i++) {
            if (roomMeetingCounts[i] > maxMeetings) {
                maxMeetings = roomMeetingCounts[i];
                roomWithMaxMeetings = i;
            }
        }

        return roomWithMaxMeetings;
    }
}