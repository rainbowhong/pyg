app.controller('sellerController',function ($scope,$controller,baseService) {

    $controller('baseController',{$scope:$scope});

    $scope.searchEntity = {};

    $scope.search = function (page,rows) {
        baseService.findByPage("/seller/findByPage",page,rows,$scope.searchEntity)
            .then(function (response) {
                $scope.dataList = response.data.rows;
                $scope.paginationConf.totalItems = response.data.total;
            })
    }

    $scope.show = function (entity) {
        $scope.entity = entity;
    }
    
    $scope.updateStatus = function (sellerId,status) {
        baseService.sendPost("/seller/updateStatus?sellerId=" + sellerId + "&status=" + status)
            .then(function (response) {
                if(response.data) {
                    $scope.reload();
                } else {
                    alert("操作失败")
                }
            })
    }

})