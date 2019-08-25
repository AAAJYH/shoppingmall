/* 加载所有种类 */
$.ajax({
    url : '/IndexController/findCategoryAll',
    type : 'post',
    dataType : 'json',
    async : true,
    success : function(data){
        console.log(JSON.stringify(data));
    }
});