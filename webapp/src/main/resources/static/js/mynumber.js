$("[type=number]").click(function () {
    var math= $(this).val();
    if(math<0){math=0}
    $(this).val(math);
});

$("[type=number]").blur(function () {
    var math= $(this).val();
    if(math<0){math=0}
    $(this).val(math);
});

