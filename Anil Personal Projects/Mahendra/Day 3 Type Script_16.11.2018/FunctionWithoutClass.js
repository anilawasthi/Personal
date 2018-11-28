function disp_details(id, name, mail_id) {
    console.log("ID is :", id);
    console.log("Name is :", name);
    if (mail_id != undefined)
        console.log("Emial Id :", mail_id);
}
disp_details(123, "Google");
console.log("**************");
disp_details(111, "google", "google@gmail.com");
// The above example declares a parameterized function. Here,
// the third parameter, i.e., mail_id is an optional parameter.
// If an optional parameter is not passed a value
// during the function call, the parameter's value is set to uundefined.
// The function prints the value of mail_id only if the argument is passed a value.
