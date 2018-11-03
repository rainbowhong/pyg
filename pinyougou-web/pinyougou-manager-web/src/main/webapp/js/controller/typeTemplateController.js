/** 定义控制器层 */
app.controller('typeTemplateController', function ($scope, $controller, baseService) {
    /** 指定继承baseController */
    $controller('baseController', {$scope: $scope});


    $scope.searchEntity = {};

    /** 查询条件对象 */
    $scope.search = function (curPage, pagesize) {
        baseService.findByPage("/typeTemplate/findByPage", curPage, pagesize, $scope.searchEntity)
            .then(function (response) {
                if (response.data) {
                    $scope.dataList = response.data.rows;
                    $scope.paginationConf.totalItems = response.data.total;
                }
            })
    }


    /** 关联品牌列表 */
    /*$scope.brandList = {data: [{id: 1, text: '联想'}, {id: 2, text: '华为'}, {id: 3, text: '小米'}]}*/
    $scope.findBrandList = function () {
        baseService.sendGet("/brand/findBrandList")
            .then(function (response) {
                $scope.brandList = {data:response.data}
            })
    }

    /** 关联规格列表 */
    $scope.findSpecList = function () {
        baseService.sendGet("/specification/findSpecList")
            .then(function (response) {
                $scope.specList = {data:response.data}
            })
    }
})