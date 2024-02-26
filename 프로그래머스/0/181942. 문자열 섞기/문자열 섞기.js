function solution(str1, str2) {
    var answer = [...str1].map((a, i) => a+str2[i]).join("");
    return answer;
}