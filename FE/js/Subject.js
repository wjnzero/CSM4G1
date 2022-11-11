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
function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/subject/list",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '    <tr>\n' +
                '        <td>Danh sách môn học</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSubject(data[i]);
            }
            document.getElementById('subject').innerHTML = content;
        }
    });
}
function getSubject(subject) {
    return `<tr><td >${subject.subject}</td>` +
        `<td><a class="deleteSubject" onclick='deleteById($(this))' href="${subject.id}">Delete</a></td></tr>`;
}

function deleteById(a){
    //lay du lieu
    // let a = $(this);
    let subjectId = a.attr("href");
    // goi ajax
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/subject/${subjectId}`,
        //xử lý khi thành công
        success: function (data) {
            successHandler();
            // a.parent().parent().remove();
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}