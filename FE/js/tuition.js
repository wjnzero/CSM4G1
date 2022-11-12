

function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.reload();
}

showListTrainer(0);

function getAllStudent() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/tuition/findAll",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day

        }
    })
    function displayStudent(array){
        for (let i = 0; i < array.length; i++) {

        }
    }
    // chặn sự kiện mặc định của thẻ

}


function deleteById(element) {
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

