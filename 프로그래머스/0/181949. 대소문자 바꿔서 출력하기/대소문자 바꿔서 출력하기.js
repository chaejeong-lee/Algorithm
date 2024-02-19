const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let result = "";
    for(let i=0;i<str.length;i++){
        let ascii = str.charCodeAt(i);
        if(ascii >=65 && ascii <= 90) ascii += 32;
        else ascii -=32;
        
        result += String.fromCharCode(ascii);
    }
    console.log(result);
});