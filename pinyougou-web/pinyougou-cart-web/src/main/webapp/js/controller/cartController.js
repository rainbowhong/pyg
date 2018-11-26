app.controller('cartController', function ($scope, $controller, baseService) {

    $controller('baseController', {$scope: $scope});


    /** 查询购物车数据*/
    $scope.findCart = function () {
        baseService.sendGet("/cart/findCart")
            .then(function (response) {
                $scope.carts = response.data;
                /** 定义总计对象*/
                $scope.totalEntity = {totalNum: 0, totalMoney: 0.00};
                for (var i = 0; i < response.data.length; i++) {
                    var cart = response.data[i];
                    for (var j = 0; j < cart.orderItems.length; j++) {
                        var orderItem = cart.orderItems[j];
                        $scope.totalEntity.totalNum += orderItem.num;
                        $scope.totalEntity.totalMoney += orderItem.totalFee;
                    }
                }
            })
    }


    /** 添加SKU 商品到购物车*/
    $scope.addCart = function (itemId, num) {
        baseService.sendGet("/cart/addCart", "itemId=" + itemId + "&num=" + num)
            .then(function (response) {
                if (response.data) {
                    $scope.findCart();
                } else {
                    alert("操作失败！")
                }
            })

    }


});