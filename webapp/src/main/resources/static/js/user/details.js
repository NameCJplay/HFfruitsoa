load();
function update() {
    $("#userId").removeAttr('readonly');
    var userImgs = $('#userImgs').val();
    if(userImgs == null || userImgs == ''){
        $('#userImgs').remove();
    }
    $.ajax({
        cache : true,
        type : "POST",
        url : "/user/update",
        data : new FormData($('#signupForm')[0]),// 你的formid
        async : false,
        contentType: false,
        processData: false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                window.parent.location.reload();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}
$("#userImgs").change(function () {
    var objurl = getObjectURL(this.files[0]);
    function getObjectURL(file)
    {
        var url = "";
        if(window.createObjectURL!=undefined)
        {
            url = window.createObjectURL(file);
        }
        else if(window.URL!=undefined || window.URL!=null)
        {
            url = window.URL.createObjectURL(file);
        }
        else if (window.webkitURL != undefined || window.webkitURL!=null)
        {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    if(objurl!=null){
        $("#userImage").attr("src", objurl);
        $('#cancelImg').css("display","inline");

    }
});
function preview() {
    window.open($("#userImage").attr("src"));
}
function cancelImg() {
    $('#cancelImg').css("display","none");
    $("#userImage").attr("src", "/user/getUserPicture");
    $("#userImgs").val('');
    console.log( $("#userImgs").val())
}
function imgbutton(){
    $("#userImgs").click();
}

$("#submit").click(function () {
    update();
});

function load() {
    $.ajax({
        cache: true,
        type: "get",
        url: "../user/detail",
        datatype: "json",
        async: false,
        success: function (data) {
            //console.log(data);
            $("#userId").val(data.userId);
            $("#userName").val(data.userName);
            $("#userMobile").val(data.userMobile);
            $("#userEmail").val(data.userEmail);
            $("#userBirth").val(data.userBirth);
            if(data.userSex=='女' && data.userSex!=null){
                $('[value = 女]').attr('selected','selected');
            }else{
                $('[value = 男]').attr('selected','selected');
            }
        }
    })
}