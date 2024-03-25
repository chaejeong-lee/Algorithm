function solution(numer1, denom1, numer2, denom2) {
    // 분자 구하기
    let num1 = numer1*denom2 + numer2*denom1;
    // 분모 구하기
    let num2 = denom1*denom2;
    
    // 최소 공약수 구하기
    // 1. a, b 서로 나누기 -> 만약 나누어진다면 b가 최대 공약수 (a>b)
    // 2. 서로가 나누어지지 않는다면 b와 a%b로 다시 나눈다.
    // 3. 서로가 나누어진다면 a%b가 최대 공약수이다. 만약 나누어지지 않는다면 다시 위 방법을 반복
    
    let gcd = calGcd(num1, num2);
    
    let answer = [num1/gcd, num2/gcd];
    return answer;
}

function calGcd(a, b){
    return (a%b===0?b:calGcd(b, a%b));
}