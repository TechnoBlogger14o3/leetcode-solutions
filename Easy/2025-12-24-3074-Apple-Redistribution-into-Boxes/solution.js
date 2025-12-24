function minBoxes(apple, capacity) {
    const totalApples = apple.reduce((a, b) => a + b, 0);
    capacity.sort((a, b) => b - a);
    
    let boxesUsed = 0;
    let currentCapacity = 0;

    for (let cap of capacity) {
        if (currentCapacity >= totalApples) break;
        currentCapacity += cap;
        boxesUsed++;
    }

    return boxesUsed;
}