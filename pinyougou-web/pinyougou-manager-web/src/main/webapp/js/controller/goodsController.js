app.controller('goodsController', function ($scope, $controller, baseService) {

    $controller('baseController', {$scope: $scope});

    $scope.status = ['未审核', '已审核', '审核未通过', '关闭'];

    $scope.searchEntity = {};

    $scope.search = function (page, rows) {
        baseService.findByPage("/goods/findByPage", page, rows, $scope.searchEntity)
            .then(function (response) {
                $scope.dataList = response.data.rows;
                $scope.paginationConf.totalItems = response.data.total;
            })
    }


    //更新状态
    $scope.updateStatus = function (status) {
        if ($scope.ids.length > 0) {
            baseService.sendGet("/goods/updateStatus?ids=" + $scope.ids + "&status="+ status)
                .then(function (response) {
                    if(response.data) {
                    $scope.reload();
                    $scope.ids = []
                    } else {
                        alert("操作失败")
                    }
                })
        } else {
            alert("请选择要审核的商品")
        }
    }


    //删除商品
    $scope.deleteAll = function () {
        if($scope.ids.length > 0) {
            baseService.deleteById("/goods/deleteAll",$scope.ids)
                .then(function (response) {
                    if(response.data) {
                        $scope.reload();
                        $scope.ids = []
                    } else {
                        alert("删除失败")
                    }
                })
        } else {
            alert("请选择要删除的商品")
        }
    }
})