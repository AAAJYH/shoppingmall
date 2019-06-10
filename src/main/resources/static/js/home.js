
/** 根据分类加载特色商品 */
function loadFeatureCommodity(classifyId) {
    $.ajax({
        url : '/IndexController/getFeatureCommodityByClassify',
        type : 'post',
        data : { classifyId : classifyId },
        async : true,
        dataType : 'json',
        success : function(data) {
            if(data != null) {

                $("#featureCommodity").empty();

                for (i in data) {
                    $("#featureCommodity").append("<div class=\"col-6 col-md-4 col-lg-3\">\n" +
                        "                      <div class=\"product\"><a class=\"product-img\" href=\"shop_detail.html\">" +
                        "                        <img src=\"/assets/images/product/product01.png\" alt=\"\"></a>\n" +
                        "                        <h5 class=\"product-type\">"+ data[i].classifyName +"</h5>\n" +
                        "                        <h3 class=\"product-name\"> "+ data[i].commodityName +" </h3>\n" +
                        "                        <h3 class=\"product-price\">$ "+ data[i].currentPrice +" \n" +
                        "                          <del>$ "+ data[i].originalPrice +" </del>\n" +
                        "                        </h3>\n" +
                        "                        <div class=\"product-select\">\n" +
                        "                          <button class=\"add-to-wishlist round-icon-btn\"> " +
                        "                           <i class=\"icon_heart_alt\"></i></button>\n" +
                        "                          <button class=\"add-to-cart round-icon-btn\">  " +
                        "                           <i class=\"icon_bag_alt\"></i></button>\n" +
                        "                          <button class=\"add-to-compare round-icon-btn\">" +
                        "                           <i class=\"fas fa-random\"></i></button>\n" +
                        "                          <button class=\"quickview round-icon-btn\">" +
                        "                           <i class=\"far fa-eye\"></i></button>\n" +
                        "                        </div>\n" +
                        "                      </div>\n" +
                        "                    </div>");
                }

            }
        }
    });
}

$(function(){

    /** 初始化加载特色商品，0表示默认 */
    loadFeatureCommodity(0);

    /** 加载特色商品分类 */
    $.ajax({
        url : '/IndexController/getFeatureClassify',
        type : 'post',
        async : true,
        dataType : 'json',
        success : function(data) {
            if(data != null) {

                $("#featureClassify").empty();

                for (i in data) {
                    if(i == 0) {
                        $("#featureClassify").append("<li>" +
                            "<a class='featureClassify active' href='javascript:loadFeatureCommodity("+ data[i].classifyId +");' > " + data[i].classifyName + " </a></li>");
                    }else {
                        $("#featureClassify").append("<li>" +
                            "<a class='featureClassify' href='javascript:loadFeatureCommodity("+ data[i].classifyId +");' > " + data[i].classifyName + " </a></li>");
                    }
                }

                /** 点击分类，更换字体颜色 */
                $(".featureClassify").click(function(){
                    $(".featureClassify").removeClass("active");
                    $(this).addClass("active");
                });

            }

        }
    });

});


