/** 定义基础控制器层 */
app.controller('baseController', function ($scope) {
    /** 定义分页配置信息对象 */
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 10,
        perPageOptions: [10, 15, 20],
        onChange: function () {
            $scope.reload();
        }
    }


    /** 当下拉列表页码发生改变，重新加载数据 */
    $scope.reload = function () {
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }


    /** 定义ids数组封装删除的id */
    $scope.ids = [];

    /** 定义checkbox点击事件函数 */
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.ids.push(id)
        } else {
            var idx = $scope.ids.indexOf(id);
            $scope.ids.splice(idx,1);
        }
    }
});