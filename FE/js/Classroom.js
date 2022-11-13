
function displayClass(){

    event.preventDefault();
    document.getElementById("display-class").hidden=false;

    successDisplayClass();
}
function  successDisplayClass(){

    $.ajax({
        type:"GET",
        url: "http://localhost:8080/classes",
        success: function (data){
            console.log(data)
            let content= '  <h1>ClassRoom List</h1>\n' +
                ' <tr>\n'+
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
    window.location.href="http://localhost:63342/CGmanagement/FE/formstory.html?_ijt=jsrrqd8qud2g4rkms1r7ck28d0"
}
function  getClassRoom(classroom){
    return `<tr><td >${classroom.nameClass}</td><td >${classroom.numberStudent}</td>`+
       `<td><button  type="submit" onclick='addStory()'>Add Story</button></td></tr>`
}