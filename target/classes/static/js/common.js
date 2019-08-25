/** 种类点击事件 */
function clickCategory(selectText,selectId){
    $("#selectText").html(selectText);
    $("#selectId").val(selectId);
    console.log($("#selectId").val());
}

/** 加载所有种类 */
$.ajax({
    url : '/CommonController/findCategoryAll',
    type : 'get',
    dataType : 'json',
    async : true,
    success : function(data){
        var rs = data;
        $("#categoryAll").empty();
        $("#categoryAll").append("<li onclick='clickCategory(\"全部种类\",0)'>全部种类</li>");

        if(rs != null) {

            for (var i in rs) {
                $("#categoryAll").append("<li onclick='clickCategory(\""+rs[i].categoryName+"\","+rs[i].categoryId+")'>"+
                    rs[i].categoryName+"</li>");
            }

        }

    }
});

/** 加载所有分类 */
$.ajax({
    url:'/CommonController/findClassifyAll',
    type:'get',
    async:'true',
    dataType:'json',
    success:function(data) {
        var rs = data;
        $("#classifyAll").empty();

        if(rs != null) {

            for(var i in rs) {
                $("#classifyAll").append("<li>" +
                    "<a href='/ShopController/shop?pageNum=1&pageSize=9&classifyId="+ rs[i].classifyId +"'>" +
                    "<i class=\"icon-1\"></i>"+rs[i].classifyName+"</a>" +
                    "</li>")
            }

        }


    }
});