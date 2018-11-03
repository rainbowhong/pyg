/** 定义控制器层 */
app.controller('spectificatoinController', function ($scope, $controller, baseService) {

    /** 指定继承baseController */
    $controller('baseController', {$scope: $scope});

    $scope.searchEntity = [];

    $scope.search = function (curPage, pageSize) {
        baseService.findByPage("/specification/findByPage", curPage, pageSize, $scope.searchEntity)
            .then(function (response) {
                $scope.dataList = response.data.rows;
                $scope.paginationConf.totalItems = response.data.total;
            })
    }

    /*添加一行规格选项*/
    $scope.addTableRow = function () {
        $scope.entity.specificationOptions.push({});
    }

    /*删除规格选项行*/
    $scope.deleteTableRow = function (index) {
        $scope.entity.specificationOptions.splice(index, 1);
    }


    /*添加或修改*/
    $scope.saveOrUpdate = function () {
        var url = "save";
        if ($scope.entity.id) {
            url = "update";
        }
        baseService.sendPost("/specification/" + url, $scope.entity)
            .then(function (response) {
                if (response.data) {
                    $scope.reload();
                } else {
                    alert("操作错误");
                }
            })
    }


    /*回显规格数据*/
    $scope.show = function (entity) {
        $scope.entity = JSON.parse(JSON.stringify(entity));
        baseService.sendGet("/specification/findSpecOption?id=" + entity.id)
            .then(function (response) {
                $scope.entity.specificationOptions = response.data;
            })
    }

    //删除选中规格
    $scope.delete = function () {
        if ($scope.ids.length > 0) {
            baseService.deleteById("/specification/delete", $scope.ids)
                .then(function (response) {
                    if (response.data) {
                        $scope.reload();
                    } else {
                        alert("请选择要删除的元素")
                    }
                })
        }
    }
});