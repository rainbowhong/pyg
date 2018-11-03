/** 定义品牌控制器层 */
app.controller('brandController', function ($scope,$controller, baseService) {
    /** 指定继承baseController */
    $controller('baseController',{$scope:$scope});


  /*  /!** 定义分页配置信息对象 *!/
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 10,
        perPageOptions: [10, 15, 20],
        onChange: function () {
            $scope.reload()
        }
    }
    /!** 当下拉列表页码发生改变，重新加载数据 *!/
    $scope.reload = function () {
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }*/

    /** 定义搜索对象 */
    $scope.searchEntity = {};
    /** 分页查询品牌 */
    $scope.search = function (curPage, pageSize) {
        baseService.findByPage("/brand/findByPage", curPage, pageSize, $scope.searchEntity)
            .then(function (response) {
                $scope.dataList = response.data.rows;
                $scope.paginationConf.totalItems = response.data.total;
            })

    }
    /** 添加或修改品牌 */
    $scope.saveOrUpdate = function () {
        var url = "save";
        if ($scope.entity.id) {
            url = "update";
        }
        /** 发送post请求添加品牌 */
        baseService.sendPost("/brand/" + url, $scope.entity)
            .then(function (response) {
                if (response.data) {
                    $scope.reload()
                } else {
                    alert("操作错误")
                }
            })

    }


    /** 显示修改 */
    $scope.show = function (entity) {
        $scope.entity = JSON.parse(JSON.stringify(entity));
    }


 /*   /!** 定义ids数组封装删除的id *!/
    $scope.ids = [];
    /!** 定义checkbox点击事件函数 *!/
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.ids.push(id);
        } else {
            var idx = $scope.ids.indexOf(id);
            $scope.ids.splice(idx, 1);
        }
    }*/


    /** 批量删除 */
    $scope.delete = function () {
        if ($scope.ids.length > 0) {
            baseService.deleteById("/brand/delete", $scope.ids)
                .then(function (response) {
                    if(response.data) {
                        $scope.reload()
                    } else {
                        alert("请选择要删除的品牌！");
                    }
                })
        }
    }
});