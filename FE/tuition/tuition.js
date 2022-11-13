// <script type="text/javascript">

    function addNewTuition() {
    //lay du lieu
    let completedFee = $('#completedFee').val();
    let totalFee = $('#totalFee').val();
    let course = $('#course').val();
    let newTuition= {
    completedFee: completedFee,
    totalFee: totalFee,
    course: course
};
    // goi ajax
    $.ajax({
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
},
    type: "POST",
    data: JSON.stringify(newTuition),
    //tên API
    url: "/tuition",
    //x? lý khi thành công
    success: successHandler

});
    //ch?n s? ki?n m?c ??nh c?a th?
    event.preventDefault();

}
    function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/tuition",
        //x? lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '    <tr>\n' +
                '        <td>completedFee</td>\n' +
                '        <td>totalFee</td>\n' +
                '        <td>course</td>\n' +
                '        <td>Delete</td>\n' +
                '        <td>Update</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getTuition(data[i]);
            }
            document.getElementById('tuitionList').innerHTML = content;
        }
    });
}

    function getTuition(tuition) {
    return `<tr><td >${tuition.completedFee}</td><td >${tuition.totalFee}</td><td >${(tuition.course).id}</td>` +
    `<td><a class="deleteTuition" href="${tuition.id}">Delete</a></td></tr>`;
}

    $(document).ready(function () {
    //s? ki?n nào th?c hi?n Ajax
    $('.deleteTuition').click(function (event) {
        //lay du lieu
        let a = $(this);
        let tuitionId = a.attr("href");
        // goi ajax
        $.ajax({
            type: "DELETE",
            //tên API
            url: `/tuition/${tuitionId}`,
            //x? lý khi thành công
            success: function (data) {
                a.parent().parent().remove();
            }

        });
        //ch?n s? ki?n m?c ??nh c?a th?
        event.preventDefault();
    });
})

// $(document).ready(function () {
//     //s? ki?n nào th?c hi?n Ajax
//     $('.updateTuition').click(function (event) {
//         //lay du lieu
//         let a = $(this);
//         let tuitionId = a.attr("href");
//         // goi ajax
//         $.ajax({
//             type: "UPDATE",
//             //tên API
//             url: `/tuition/${tuitionId}`,
//             //x? lý khi thành công
//             success: function (data) {
//                 a.parent().parent().remove();
//             }
//
//         });
//         //ch?n s? ki?n m?c ??nh c?a th?
//         event.preventDefault();
//     });
// })
// function updateUserAsync(user) {
//     return $.ajax({
//         method: "PUT",
//         url: API_ROOT + "/" + user.id,
//         data: user,
//     });
// }