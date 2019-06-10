/** 默认显示9条 */
var pageSize = 9;
var classifyId = $("#classifyId").val();

/** 跳转首页 */
$("#index").click(function(){
    window.location.href = "http://127.0.0.1/front/index.html";
});

/** 分页查询 */
function pageClick(pageNum) {
    if(classifyId != "") {
        window.location.href = "/ShopController/shop?pageNum="+ pageNum +"&pageSize=" + pageSize +"&classifyId="+ classifyId;
    }else {
        window.location.href = "/ShopController/shop?pageNum="+ pageNum +"&pageSize=" + pageSize;
    }
}

/** 跳转到商品详情页面 */
function redirectShopDetail(commodityId) {
    window.location.href = "/front/shop_detail.html?commodityId="+ commodityId;
}

$(function() {

    /** 商品排序 */
    // $("#sort").change(function() {
    //     var sortType = $(this).val();
    //     var pageNum =  [[${commodityPageInfo.pageNum}]]
    //     window.location.href = "/ShopController/shop?pageNum="+ pageNum +"&pageSize=" + pageSize;
    // });

});
