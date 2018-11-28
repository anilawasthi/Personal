// The variable's type is inferred from the data type of the value
// Here, the variable is of the type string

var lname;

// The variable's data tyoe is any. Its value is set to undefined
// Example: Variable Scope

var global_num = 12 // global variable

class Employee {
    num_val = 13;       //class variable
    static sval = 10;   //static field

    storeNum():void{
        var local_num=14;   //local variable
        console.log("inside class" +global_num);
    }
}

console.log("Global num: "+global_num)
console.log(Employee.sval)  //static variable
var obj = new Employee();
console.log("Global num: "+obj.num_val)