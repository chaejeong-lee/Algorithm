function solution(a, b) {
    var num1 = String(a)+String(b);
    var num2 = String(b)+String(a);
    
    return num1>num2?Number(num1):Number(num2);
}