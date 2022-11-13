let tk = localStorage.getItem("token");
let rl = localStorage.getItem("role");
// let token = "";
// let object = JSON.parse(rl);
if (tk == null){
    window.location.href = "Login.html"
}
// else if (rl != "ROLE_ADMIN"){
//     window.location.href = "Login.html"
// }
function logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.reload();
}

function successHandler() {
    $.ajax({
        type: "GET",
        url: "/register",
        success: function (data) {
            let content =
                `<tr>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Birth Date</td>
                        <td>Email</td>
                        <td>Phone</td>
                        <td>Account</td>
                        <td>Password</td>
                        <td>Status</td>
                        <td>Image</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>`;
            if (data == null) {
                document.getElementById("teacherList").innerHTML = content;
            } else {
                for (let i = 0; i < data.length; i++) {
                    content += getTeacher(data[i]);
                }
                document.getElementById("teacherList").innerHTML = content;
            }
        }
    })
}

function displayFormCreateUser() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("form-register-card").hidden = false;
    document.getElementById("form-button-submit").onclick = function () {
        addNewUser();
    }
}
    function displayFormCreateCourse() {
        event.preventDefault();
        // document.getElementById("form-register").reset()
        document.getElementById("form-create-object-card").hidden = false;
        document.getElementById("form-button-submit-course").onclick = function () {
            addNewCource();
        }
    }
        function addNewUser() {
            //chặn sự kiện mặc định của thẻ
            event.preventDefault();
            //lay du lieu
            let firstName = $("#first-name").val();
            let email = $("#email").val();
            let phone = $("#phone").val();
            let password = $("#password").val();
            let role = $("#role").val();
            let newUser = {
                fullName: firstName,
                email: email,
                phoneNumber: phone,
                password: password,
                identity: role,
            };
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                data: JSON.stringify(newUser),
                //tên API
                url: "http://localhost:8080/register",
                //xử lý khi thành công
                // success: successHandler
            });
        }

        function addNewCource() {
            //chặn sự kiện mặc định của thẻ
            event.preventDefault();
            //lay du lieu
            let name = $("#course-name").val();
            let newCourse = {
                id: null,
                name : name,
            };
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                data: JSON.stringify(newCourse),
                //tên API
                url: "http://localhost:8080/create-course",
                //xử lý khi thành công
                // success: successHandler
            });
        }

