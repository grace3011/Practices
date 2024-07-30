
function greet1(name: string, greeting?: string):void {
    if (greeting) {
        console.log(`${greeting}, ${name}!`);
    } else {
        console.log(`Good Day, ${name}!`);
    }
}


greet1("vino"); 
greet1("vino", "ashok"); 
