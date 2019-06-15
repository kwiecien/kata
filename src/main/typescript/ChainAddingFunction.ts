export default function add(x: number): any {
    function curryAdd(y: number): number {
        return add(x + y);
    }

    curryAdd.valueOf = (): number => x;
    return curryAdd;
}
