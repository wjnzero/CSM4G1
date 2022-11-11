// let tk = localStorage.getItem("token");
// let rl = localStorage.getItem("role");
// // let token = "";
// // let object = JSON.parse(rl);
// if (tk == null){
//     window.location.href = "Login.html"
// }
// else if (rl != "ROLE_STAFF"){
//     window.location.href = "Login.html"
// }

function logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.reload();
}
showListTrainer(0);

function showListTrainer(page) {
    let next = page + 1;
    let previous = page - 1;
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/mark/findAll",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '    <tr>\n' +
                '        <td>Name</td>\n' +
                '        <td>Lecture</td>\n' +
                '        <td>Tutorial</td>\n' +
                '        <td>View</td>\n' +
                '        <td>Edit</td>\n' +
                '        <td>Delete</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.content.length; i++) {
                content += getTrainer(data.content[i]);
            }
            content += '<div>\n' +
                '  <button onclick=showListTrainer('+previous+')>Previous</button>\n' +
                + (data.pageable.pageNumber + 1) + '/' + data.totalPages +
                '  <button onclick=showListTrainer('+next+')>Next</button>\n' +
                '</div>';
            document.getElementById('trainerList').innerHTML = content;
        }
    });
    // chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function getTrainer(trainer) {
    return `<tr><td >${trainer.name}</td>
                <td >${trainer.dateOfBirth}</td>
                <td >${trainer.address}</td>` +
        `<td><a class="action" href="../trainerRS/view.html">View</a></td>` +
        `<td><a class="action" href="../trainerCUD/update/update.html">Edit</a></td>` +
        `<td><a class="action" href="${trainer.id}" onclick="deleteById(this)">Delete</a></td>
                </tr>`;
}

function deleteById(element){
    //lay du lieu
    let id = element.getAttribute("href");
    // goi ajax
    $.ajax({
        type: "DELETE",
        //tên API
        url: "http://localhost:8080/marl/delete" + id,
        //xử lý khi thành công
        success: function (data) {
            console.log("Xoa thanh cong ");
            showListTrainer();
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

