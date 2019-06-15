export function countSheeps(arrayOfSheep: boolean[]) {
    return arrayOfSheep.filter(function isTruthy(sheep) {
        return sheep
    }).length
}
