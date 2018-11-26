app.controller('orderController', function ($scope, $controller, baseService) {

    $controller('cartController', {$scope: $scope});


    //获取收件人地址
    $scope.findAddressByUser = function () {
        baseService.sendGet("/order/findAddressByUser")
            .then(function (response) {
                $scope.addressList = response.data;
                /* for(var i in response.data) {
                     if(i.isDefault == 1) {
                         $scope.address = i;
                         break;
                     }
                 }*/
                for (var i = 0; i < $scope.addressList.length; i++) {
                    var address = $scope.addressList[i];
                    if (address.isDefault == 1) {
                        $scope.address = address;
                    }
                }
            })
    };


    //是否选中地址
    $scope.isSelectedAddress = function (item) {
        return $scope.address == item;
    };

    //选中地址
    $scope.selectAddress = function (item) {
        $scope.address = item;
    };


    /** 定义order 对象封装参数*/
    $scope.order = {paymentType: '1'};
    /*选择支付方式*/
    $scope.selectPayType = function (type) {
        $scope.order.paymentType = type;
    }


    /*保存订单*/
    $scope.saveOrder = function () {
        // 设置收件人地址
        $scope.order.receiverAreaName = $scope.address.address;
        // 设置收件人手机号码
        $scope.order.receiverMobile = $scope.address.mobile;
        //设置收件人
        $scope.order.receiver = $scope.address.contact;
        //发送异步请求
        baseService.sendPost("/order/save", $scope.order)
            .then(function (response) {
                if (response.data) {
                    // 如果是微信支付，跳转到扫码支付页面
                    if ($scope.order.paymentType == 1) {
                        location.href = "/order/pay.html";
                    } else {
                        //如果是货到付款，跳转到成功页面
                        location.href = "order/paysuccess.html";
                    }
                } else {
                    alert("订单提交失败！");
                }
            })
    }
});