var angleClock = function(hour, minutes) {
    const minuteAngle = minutes * 6; // 360 degrees / 60 minutes
    const hourAngle = (hour % 12) * 30 + minutes * 0.5; // 360 degrees / 12 hours + 30 degrees / 60 minutes
    const angle = Math.abs(hourAngle - minuteAngle);
    return Math.min(angle, 360 - angle);
};