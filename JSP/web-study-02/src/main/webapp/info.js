function check(){
    if(document.frm.name.value == ""){
        alert("이름을 입력하세요.")
        document.frm.name.focus();
        return false;
    }else if(document.frm.addr.value == ""){
        alert("주소를 입력하세요.")
        document.frm.addr.focus();
        return false;
    }else {
        return true;
    }
}


function check2(){
    if(document.frm2.name.value == ""){
        alert("이름을 입력하세요.")
        document.frm2.name.focus();
        return false;
    }else if(document.frm2.addr.value == ""){
        alert("주소를 입력하세요.")
        document.frm2.addr.focus();
        return false;
    }else {
        return true;
    }
}