/** 定义首页控制器层 */
app.controller("indexController", function ($scope, baseService) {

    $scope.findContentByCategoryId = function (id) {
        baseService.sendGet("/content/findContentByCategoryId?categoryId=" + id)
            .then(function (response) {
                $scope.contentList = response.data;
            })
    }
});