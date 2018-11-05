/** 定义控制器层 */
app.controller('itemCatController',function ($scope,$controller,baseService) {
    /** 指定继承baseController */
    $controller('baseController',{$scope:$scope});

    $scope.findItemCatByParentId = function (parentId) {
        baseService.sendGet("/itemCat/findItemCatByParentId","parentId=" + parentId)
            .then(function (response) {
                $scope.dataList = response.data;
            })
    }


    /** 默认为1级 */
    $scope.grade = 1;
    /** 默认为1级 */
    $scope.selectList = function (entity,grade) {
        $scope.grade = grade;
        if(grade == 1) {
            $scope.itemCat_1 = null;
            $scope.itemCat_2 = null;
        }

        if(grade == 2) {
            $scope.itemCat_1 = entity;
            $scope.itemCat_2 = null;
        }

        if(grade == 3) {
            $scope.itemCat_2 = entity;
        }
        $scope.findItemCatByParentId(entity.id);
    }
});