function addNumbers() {
    var nums = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        nums[_i] = arguments[_i];
    }
    var i;
    var sum = 0;
    for (i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
    }
    console.log("sum of the numbers", sum);
}
addNumbers(1, 2, 3);
addNumbers(10, 10, 10, 10, 10);
// The function addNumbers() declaration, accepts a rest parameter nums. (...) this value is actually the rest parameter used on top while declaring the function
// The rest parameter's data type must be set to an array.
// Moreover, a function can have at the most one rest parameter.
// The function is invoked twice by passing three and six values, respectively.
// The for loop iterates through the argument list, passed to the function and calc
