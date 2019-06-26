/** 根据商品Id查询商品详情 */
function getCommodity(commodityId) {
    $.ajax({
        url:'/shopDetailController/getCommodityByCommodityId',
        data:{commodityId:commodityId},
        type:'post',
        async:true,
        success:function(data) {
            console.log(JSON.stringify(data));
            $("#shopDetail").empty();
            $("#shopDetail").html("<h5 class=\"product-type color-type\">"+ data.classifyName +"</h5>\n" +
                "                        <h2 class=\"product-name\">"+ data.commodityName +"</h2>\n" +
                "                        <p class=\"product-describe\">"+ data.commodityExplaini +"</p>" +
                "                       <a class=\"product-more\" href=\"#\">View more <i class=\"arrow_carrot-2right\"></i></a>\n" +
                "                        <p class=\"delivery-status\">免费邮递</p>\n" +
                "                        <div class=\"price-rate\">\n" +
                "                          <h3 class=\"product-price\">\n" +
                "                            <del>$"+ parseFloat(data.originalPrice) +"</del>$"+ parseFloat(data.currentPrice) +"\n" +
                "                          </h3>\n" +
                "                        <h5 class=\"product-rated\"><i class=\"icon_star\"></i><i class=\"icon_star\"></i>" +
                "                       <i class=\"icon_star\"></i><i class=\"icon_star\"></i>" +
                "                       <i class=\"icon_star-half\"></i><span>(15)</span></h5>\n" +
                "                      </div>\n" +
                "                      <div class=\"color-select\">\n" +
                "                        <h5>Select Color:</h5><a class=\"color bg-danger\" href=\"#\"></a>" +
                "                       <a class=\"color bg-success\" href=\"#\"></a><a class=\"color bg-info\" href=\"#\"></a>\n" +
                "                      </div>\n" +
                "                      <div class=\"quantity-select\">\n" +
                "                        <label for=\"quantity\">数量:</label>\n" +
                "                        <input class=\"no-round-input\" id=\"quantity\" type=\"number\" min=\"0\" value=\"1\">\n" +
                "                      </div>\n" +
                "                      <div class=\"product-select\">\n" +
                "                        <button class=\"add-to-cart normal-btn outline\" onclick='addCard("+data.commodityId+")'>添加到购物车</button>\n" +
                "                        <button class=\"add-to-compare normal-btn outline\">+ Add to Compare</button>\n" +
                "                      </div>\n" +
                "                      <div class=\"product-share\">\n" +
                "                        <h5>分享链接:</h5><a href=\"\"><i class=\"fab fa-facebook-f\"> </i></a>" +
                "                           <a href=\"\"><i class=\"fab fa-twitter\"></i></a>" +
                "                           <a href=\"\"><i class=\"fab fa-invision\"> </i></a>" +
                "                           <a href=\"\"><i class=\"fab fa-pinterest-p\"></i></a>\n" +
                "                      </div>");
        }
    });
}

/** 添加到购物车 */
function addCard(commodityId) {
    $.ajax({
        url : '/shopDetailController/addCard',
        type : 'post',
        data : {commodityId : commodityId},
        dataType : "text",
        success : function(data) {
            if(data > 0) {
                alert("成功加入购物车");
            }else {
                alert("加入失败，再试一下");
            }
        }
    });

}

$(function(){
    /**  */
    var search = location.search;
    var commodityId = search.substr(search.indexOf("=")+1, search.length);
    console.log("commodityId："+ commodityId);

    /** 加载商品信息 */
    if(commodityId != "") {
        getCommodity(commodityId);
    }

});