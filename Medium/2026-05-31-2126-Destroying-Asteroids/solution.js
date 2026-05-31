var asteroidsDestroyed = function(mass, asteroids) {
    asteroids.sort((a, b) => a - b);
    for (let asteroid of asteroids) {
        if (mass >= asteroid) {
            mass += asteroid;
        } else {
            return false;
        }
    }
    return true;
};