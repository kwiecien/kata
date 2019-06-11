export function positiveSum(arr: number[]): number {
  return arr.filter(n => n > 0).reduce((a, b) => a + b, 0);
}
