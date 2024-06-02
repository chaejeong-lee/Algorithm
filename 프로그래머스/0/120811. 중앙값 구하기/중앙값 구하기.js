function solution(array) {
    array.sort((a, b) => a-b);
    let num = Math.floor(array.length/2);
    return array[num];
}