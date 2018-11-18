/** 定义首页控制器层 */
app.controller("indexController", function ($scope, baseService) {

    $scope.findContentByCategoryId = function (id) {
        baseService.sendGet("/content/findContentByCategoryId?categoryId=" + id)
            .then(function (response) {
                $scope.contentList = response.data;
            })
    }



    /** 跳转到搜索系统 */
    $scope.search =function () {
        var keyword = $scope.keywords ? $scope.keywords : '';
        location.href = "http://search.pinyougou.com?keywords=" + keyword;
    }
});