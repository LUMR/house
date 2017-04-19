/**
 * check js
 * Created by fsweb on 17-4-10.
 */
var xmlHttp = new XMLHttpRequest();
var NameNotExist = false;
function checkInput() {
    message = document.getElementById("message");
    if (NameNotExist == false) {
        message.innerHTML = "请先验证用户名";
        return false;
    }
    doc = document.getElementsByTagName("input");
    for (i = 0; i < doc.length; i++) {
        if (doc[i].value == "") {
            message.innerHTML = "请填写完整信息";
            return false;
        }
    }
    return true;
}

function checkUserName(doc_name) {
    var name = doc_name.value;
    xmlHttp.open("POST", "/checkuser",true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.onreadystatechange = callBackName;
    xmlHttp.send("name=" + name);
}

function callBackName() {
    if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {
        var mes = document.getElementById("checkName");
        if (xmlHttp.responseText == "true") {
            NameNotExist = true;
            mes.innerHTML = "可以使用";
        }
        else {
            NameNotExist = false;
            mes.innerHTML = "已存在"
        }
        // alert(NameNotExist);
    }
}

function get_street(dist) {
    var district = dist.value;
    $("#street").load("/get_streets",{"did":district},function(data,statusTxt,xhr){callBack_street(data,statusTxt,xhr);})
}

function get_dist() {
    $("#district").load("/get_dist");
}

function get_types() {
    $("#types").load("/get_types");
}

function callBack_street(data,statusTxt,xhr) {
    if(statusTxt=="error")
        alert("Error: "+xhr.status+": "+xhr.statusText);
}
