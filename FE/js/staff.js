
function getAllStudent() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("student").hidden = false;
    getStudent();
}
function getStudent() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/mark/findAll",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            console.log(data)
            let content = '  <tr>\n' +
                '       <td style="font-size: 30px" >Full Name</td>\n' +
                '        <td style="font-size: 30px" >Lecture</td>\n' +
                '        <td style="font-size: 30px" >Tutorial</td>\n' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getStudent1(data[i]);
            }
            document.getElementById("displayStudent").innerHTML = content;
        }
    })
}
function getStudent1(student) {
    return `<tr><td >${student.full_name}</td><td >${student.lecture}</td><td >${student.tutorial}</td>`
}






//     successDisplayClass()
//
//     function successDisplayClass() {
//         $.ajax({
//             type: "GET",
//             url: "http://localhost:8080/classes",
//             success: function (data) {
//                 console.log(data)
//                 let content = '  <tr>\n' +
//                     '       <td>nameClass</td>\n' +
//                     '        <td>numberStudent</td>\n' +
//                     '        <td>AddStory</td>\n' +
//                     '</tr>';
//                 for (let i = 0; i < data.length; i++) {
//                     content += getClassRoom(data[i]);
//                 }
//                 document.getElementById("displayClassroom").innerHTML = content;
//             }
//         });
//     }
//
//     function getClassRoom(classroom) {
//         return `<tr><td >${classroom.nameClass}</td><td >${classroom.numberStudent}</td>` +
//             `<td><button  type="submit" onclick='addStory()'>Add Story</button></td></tr>`
//     }
//
//     function deleteById(element) {
//         //lay du lieu
//         let id = element.getAttribute("href");
//         // goi ajax
//         $.ajax({
//             type: "DELETE",
//             //tên API
//             url: "http://localhost:8080/marl/delete" + id,
//             //xử lý khi thành công
//             success: function (data) {
//                 console.log("Xoa thanh cong ");
//                 showListTrainer();
//             }
//
//         });
//         //chặn sự kiện mặc định của thẻ
//         event.preventDefault();
//     }
// }
//
