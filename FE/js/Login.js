function Login() {
    event.preventDefault();
    //lay du lieu
    //lay username, password
    let email = $("#email").val();
    let password = $("#password").val();
    //tao object
    let user ={
        "email": email,
        "password": password
    }
    $.ajax({
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/login",
        data: JSON.stringify(user),
        success: function (data) {
            localStorage.setItem("token", data.accessToken);
            localStorage.setItem("role",data.roles[0].authority);

            if (data.roles[0].authority == "ROLE_ADMIN"){
                location.href = "Admin.html"
            }else if(data.roles[0].authority == "ROLE_TEACHER"){
                location.href = "teacher.html"
            }else if(data.roles[0].authority == "ROLE_STUDENT"){
                location.href = "student.html"
            }else if(data.roles[0].authority == "ROLE_STAFF"){
                location.href = "student.html"
            }else {
                alert("lon")
                location.href = "Login.html"
            }
            console.log(data)
        },
        error: function (err) {
            console.log(err)
        }
    })

}
