$(function(){
    var username = '<%= session.getAttribute("username")%>';
    console.log("username:::" + username);
});