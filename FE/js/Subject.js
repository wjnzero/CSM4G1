function successHandler() {
    $.ajax({
        type: "GET",
        url: "/subject/list",
        success: function (data) {
            let content =
                `<tr>
                        <td>Name</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>`;
            if (data == null) {
                document.getElementById("subjectList").innerHTML = content;
            } else {
                for (let i = 0; i < data.length; i++) {
                    content += getTeacher(data[i]);
                }
                document.getElementById("subjectList").innerHTML = content;
            }
        }
    })
}

function displayFormCreate() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("form-register-card").hidden = false;
    document.getElementById("form-button-submit").onclick = function () {
        addNewUser();
    }

    function addNewSubject() {
        event.preventDefault();
        //Lấy dữ liệu
        let name = $("#name").val();
        let newSubject = {
            name: name
        };
        // Gọi Ajax
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newSubject),
            //tên API
            url: "http://localhost:8080/subject/create",
            //xử lý khi thành công
            success: successHandler

        });
    }
}
