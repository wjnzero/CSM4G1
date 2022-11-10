let tk = localStorage.getItem("token");
let rl = localStorage.getItem("role");
// let token = "";
// let object = JSON.parse(rl);
if (tk == null){
    window.location.href = "Login.html"
}
else if (rl != "ROLE_ADMIN"){
    window.location.href = "Login.html"
}

function logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.reload();
}
