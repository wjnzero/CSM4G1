successDisplayClass()
function  successDisplayClass(){
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/classes",
        success: function (data){
            console.log(data)
            let content= '  <tr>\n'+
                '       <td>nameClass</td>\n'+
                '        <td>numberStudent</td>\n'+
                '        <td>AddStory</td>\n'+
                '</tr>';
            for (let i = 0; i<data.length; i++){
                content += getClassRoom(data[i]);
            }
            document.getElementById("displayClassroom").innerHTML= content;
        }
    });
}
function addStory(){
    window.location.href="../story/formstory.html"
}
function  getClassRoom(classroom){
    return `<tr><td >${classroom.nameClass}</td><td >${classroom.numberStudent}</td>`+
       `<td><button  type="submit" onclick='addStory()'>Add Story</button></td></tr>`
}