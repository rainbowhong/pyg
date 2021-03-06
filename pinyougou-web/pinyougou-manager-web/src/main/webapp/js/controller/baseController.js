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

    /** 提取数组中json某个属性，返回拼接的字符串(逗号分隔) */
    $scope.jsonArr2Str = function (jsonArrStr,key) {
        // 把jsonArrStr转化成JSON数组对象
        var jsonArr = JSON.parse(jsonArrStr);
        // 定义新数组
        var resArr = [];
        // 迭代json数组
        for(var i = 0; i < jsonArr.length; i++) {
            // 取数组中的一个元素
            var json = jsonArr[i];
            // 把json对象的值添加到新数组
            resArr.push(json[key]);
        }

        // 返回数组中的元素用逗号分隔的字符串
        return resArr.join(",");
    }
});