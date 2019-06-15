export function countSheeps(arrayOfSheep: boolean[]) {
    return arrayOfSheep.filter(function isTruthy(sheep) {
        return sheep
    }).length
}

export function countSheeps2(arrayOfSheep: boolean[]) {
    return arrayOfSheep.filter(Boolean).length
}
