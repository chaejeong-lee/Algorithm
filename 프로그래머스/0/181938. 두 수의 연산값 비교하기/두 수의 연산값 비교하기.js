function solution(a, b) {
    
    var answer = Number(String(a)+String(b));
    
    if(answer<2*Number(a)*Number(b)){
        answer = 2*Number(a)*Number(b);
    }
    return answer;
}