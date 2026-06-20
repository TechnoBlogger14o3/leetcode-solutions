var maximumBuilding = function(n, restrictions) {
    restrictions.push([1, 0]);
    restrictions.push([n, 0]);
    restrictions.sort((a, b) => a[0] - b[0]);

    for (let i = 1; i < restrictions.length; i++) {
        const [prevId, prevHeight] = restrictions[i - 1];
        const [currId, currHeight] = restrictions[i];
        const maxHeight = Math.floor((currHeight + prevHeight + currId - prevId) / 2);
        restrictions[i][1] = Math.min(currHeight, maxHeight);
    }

    for (let i = restrictions.length - 2; i >= 0; i--) {
        const [currId, currHeight] = restrictions[i];
        const [nextId, nextHeight] = restrictions[i + 1];
        const maxHeight = Math.floor((currHeight + nextHeight + nextId - currId) / 2);
        restrictions[i][1] = Math.min(currHeight, maxHeight);
    }

    let maxBuildingHeight = 0;
    for (let i = 0; i < restrictions.length - 1; i++) {
        const [currId, currHeight] = restrictions[i];
        const [nextId, nextHeight] = restrictions[i + 1];
        const distance = nextId - currId;
        const height = Math.min(currHeight, nextHeight) + Math.floor(distance / 2);
        maxBuildingHeight = Math.max(maxBuildingHeight, height);
    }

    return maxBuildingHeight + Math.floor((n - 1) / 2);
};