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
                $scope.brandList = {data: response.data}
            })
    }

    /** 关联规格列表 */
    $scope.findSpecList = function () {
        baseService.sendGet("/specification/findSpecList")
            .then(function (response) {
                $scope.specList = {data: response.data}
            })
    }

    //添加行
    $scope.addTableRow = function () {
        $scope.entity.customAttributeItems.push({});
    }

    //删除行
    $scope.deleteTableRow = function (index) {
        $scope.entity.customAttributeItems.splice(index, 1);
    }

    //添加或更新行
    $scope.saveOrUpdate = function () {
        var url = "save";
        if ($scope.entity.id) {
            url = "update";
        }
        baseService.sendPost("/typeTemplate/" + url, $scope.entity)
            .then(function (response) {
                if (response.data) {
                    $scope.reload();
                } else {
                    alert("操作失败");
                }
            })
    }

    //修改时数据回显
    $scope.show = function (entity) {
        $scope.entity = JSON.parse(JSON.stringify(entity))
        $scope.entity.brandIds = JSON.parse(entity.brandIds);
        $scope.entity.specIds = JSON.parse(entity.specIds);
        $scope.entity.customAttributeItems = JSON.parse(entity.customAttributeItems);
    }

    //删除模板
    $scope.delete = function () {
        if ($scope.ids.length > 0) {
            baseService.deleteById("/typeTemplate/delete?", $scope.ids)
                .then(function (response) {
                    if (response.data) {
                        $scope.reload();
                    } else {
                        alert("请选中要删除的元素")
                    }
                })
        }
    }
})