$(function() {
    loadShoppinCartList();
});

/** 加载购物车数据 */
function loadShoppinCartList() {
    $.ajax({
        url : '/ShopCartController/getShoppingCartList',
        type : 'post',
        dataType : 'json',
        success : function(data) {
            console.log(JSON.stringify(data));
            var totalNum = 0; //总数量
            var totalPrice = 0; //总价格
            $("#shoppingCartList").empty();
            var html = "";
            for(var i = 0; i <  data.length; i++) {
                totalNum += data[i].commodityNum;
                totalPrice += data[i].commodityPrice * data[i].commodityNum;
                $("#shoppingCartList").append("<tr>\n" +
                    "                      <td class=\"product-iamge\">\n" +
                    "                        <div class=\"img-wrapper\"><img src='/images/"+ data[i].commodityPicture +"' alt=\"product image\"></div>\n" +
                    "                      </td>\n" +
                    "                      <td class=\"product-name\">"+ data[i].commodityName +"</td>\n" +
                    "                      <td class=\"product-price\">$"+ data[i].commodityPrice +"</td>\n" +
                    "                      <td class=\"product-quantity\">\n" +
                    "                        <input class=\"quantity no-round-input\" type=\"number\" min=\"1\" value="+ data[i].commodityNum +">\n" +
                    "                      </td>\n" +
                    "                      <td class=\"product-total\">$"+ data[i].commodityPrice * data[i].commodityNum +"</td>\n" +
                    "                      <td class=\"product-clear\">\n" +
                    "                        <button class=\"no-round-btn\" onclick='deleteShoppingCart("+data[i].shoppingCartId+")'><i class=\"icon_close\"></i></button>\n" +
                    "                      </td>\n" +
                    "                    </tr>");
            }
            /** 设置总价格、总数量 */
            $("#totalNum").text(totalNum);
            $("#totalPrice").text("$"+ totalPrice);

        }
    });
}

/** 删除购物车信息 */
function deleteShoppingCart(shoppingCartId) {
    $.ajax({
        url : '/ShopCartController/deleteShoppingCart',
        type : 'post',
        data : {shoppingCartId : shoppingCartId},
        dataType : 'text',
        success : function(data) {
            console.log(JSON.stringify(data));
            if(data == 1) {
                /** 重新加载购物车数据 */
                loadShoppinCartList();
            }
        }
    });
}

/** 清空购物车 */
function emptyShoppingCart() {
    $.ajax({
        url : "/ShopCartController/emptyShoppingCart",
        type : "post",
        dataType : "text",
        success : function(data) {
            console.log("清空结果："+ data);
            if(data == 1) {
                /** 清空购物车数据，不再去访问数据库 */
                $("#shoppingCartList").empty();
            }
        }
    })
}