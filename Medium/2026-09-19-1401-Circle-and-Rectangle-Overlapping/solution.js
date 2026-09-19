var checkOverlap = function(radius, xCenter, yCenter, x1, y1, x2, y2) {
    const closestX = Math.max(x1, Math.min(xCenter, x2));
    const closestY = Math.max(y1, Math.min(yCenter, y2));
    const distanceX = xCenter - closestX;
    const distanceY = yCenter - closestY;
    return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
};