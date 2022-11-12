
function addNewStory(){
    let content =$('#content').val();
    let newStories ={
        content: content
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newStories),
        url: "http://localhost:8080/stories/create",
        success:tabStory

    });

}
function tabStory(){
    let content="Add Success"
    document.getElementById('success').innerHTML=content;
}