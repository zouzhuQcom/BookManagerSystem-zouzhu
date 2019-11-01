/*
*     描述 : 登录功能, 当点击登录时弹窗显示
*
*     auther : zouzhu
* */
$(function(){
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').focus()
    });
})



/*
*     描述 : 借书时弹窗显示, 获取点击的 书名，价格，作者，来填充借阅板块数据
*
*     auther : zouzhu
* */
function jieshu(setName, setAuther, setPrice, setPress){
    $(".set_book_name").text(setName);
    $(".set_book_auther").text(setAuther);
    $(".set_book_press").text(setPress);
    $(".set_book_price").text(setPrice);
    $(".jieshu_block").css('display',"block");
}



/*
*   描述 : 当点击借阅的图书的时候，如果在馆，则弹出借阅模块，否则弹出警告模块
*
*   author : zouzhu
* */
$(function () {

    $(".start1").click(function () {
        if ($(this).attr('class').split(" ")[2]=="code606") {
            bookID = $(this).attr('class').split(" ")[0];               // 当点击该项时, 获取主键 ID
            var book_name = $(this).children("td.book_name").text();
            var book_auther = $(this).children("td.book_auther").text();
            var book_press = $(this).children("td.book_press").text();
            var book_price = $(this).children("td.book_price").text();
            jieshu(book_name, book_auther, book_press, book_price);
        }else{
            alert("你还未登录 ！还不能使用借书功能 !");
        }
    });
    $(".start0").click(function () {
        if($(this).attr('class').split(" ")[2]=="code606"){
            var book_name = $(this).children("td.book_name").text();
            alert("《" + book_name + "》" + " ! 该图书目前不在图书馆, 请先留意别的图书 。");
        }else{
            alert("你还未登录 ！还不能使用借书功能 !");
        }
    });
})
/*描述 : 隐藏功能*/
function yingchang(){
    $(".jieshu_block").css('display','none');
}



/*
*   描述 ： 如果图书状态为在馆, 点击借阅时，向服务器发送 ajax 请求
*
*   auther ： zouzhu
* */
var bookID;
function jieshi_ajax(){
    $.ajax({
        type: "POST",
        url: "/booksystem/jieshu_request_controller/" + bookID,
        success: function (value) {
            if(value==1){
                window.location.reload();
            }
            yingchang();
        }
    });
}









/*
*       描述 : 还书过程中的弹窗
*
*       author : zouzhu
*
*       time : 2019/10/17    20:20
* */


function huanshu(book_name, book_day, book_money, book_moneys){
    $(".set_book_name").text(book_name);
    $(".set_book_day").text(book_day);
    $(".set_book_money").text(book_money);
    $(".set_book_moneys").text(book_moneys);
    $(".huanshu_block").css('display',"block");
}

$(function () {


    $(".start_huanshu0").click(function () {
        huanshu_book_ID = $(this).attr("class").split(" ")[0];
        huanshu_user_ID = $(this).attr("class").split(" ")[1];

        var book_name = $(this).children("td.book_name").text();
        var book_day = $(this).children("td.book_day").text();
        var book_money = $(this).children("td.book_money").text();
        var book_moneys = $(this).children("td.book_moneys").text();
        huanshu(book_name, book_day, book_money, book_moneys);
    });

})

function huanshu_yingchang(){
    $(".huanshu_block").css('display','none');
}

/*
*   logID
* */
var huanshu_book_ID;
var huanshu_user_ID
function huanshu_ajax(){
    $.ajax({
        type: "POST",
        url: "/booksystem/huanshu_request_controller/" + huanshu_book_ID + "/" + huanshu_user_ID,
        success: function (value) {
            if(value==1){
                alert("还书成功 ! " + huanshu_user_ID + " >>> " + huanshu_book_ID);
                window.location.reload();
            }
            yingchang();
        }
    });
}











/*
*       管理员界面
* */
function block_display(displayBlockName){
    $(displayBlockName).css("display", "block");
}

function managerYingChang(noneBlockName){
    $(noneBlockName).css("display", "none");
}

$(function(){
    var managerBookID;
    $(".manager tr").click(function(){
        managerBookID = $(this).attr("class").split(" ")[0];
        $(".set_book_name").text($(this).children("td.book_name").text());
        $(".set_book_auther").text($(this).children("td.book_author").text());
        $(".set_book_adder").text($(this).children("td.book_adder").text());
        $(".set_book_price").text($(this).children("td.book_price").text());
        block_display(".manager_block");
    });

    $(".manager_shangjia").click(function () {

        block_display(".manager_shangjia_mianbang");
    });

    $(".xiajia_btn_ajax_class").click(function () {
        $.ajax({
            type: "POST",
            url: "/systembook/manager/xiajia/" + managerBookID,
            success: function (value) {
                if(value==1){
                    alert("下架成功");
                    window.location.reload();
                }
                managerYingChang(".manager_block");
            }
        })
    })

})