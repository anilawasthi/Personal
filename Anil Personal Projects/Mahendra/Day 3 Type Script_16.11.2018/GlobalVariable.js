// The variable's type is inferred from the data type of the value
// Here, the variable is of the type string
var lname;
// The variable's data tyoe is any. Its value is set to undefined
// Example: Variable Scope
var global_num = 12; // global variable
var Employee = /** @class */ (function () {
    function Employee() {
        this.num_val = 13; //class variable
    }
    Employee.prototype.storeNum = function () {
        var local_num = 14; //local variable
        console.log("inside class" + global_num);
    };
    Employee.sval = 10; //static field
    return Employee;
}());
console.log("Global num: " + global_num);
console.log(Employee.sval); //static variable
var obj = new Employee();
console.log("Global num: " + obj.num_val);
