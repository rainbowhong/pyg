app.controller('indexController',function ($scope,baseService) {
    
    $scope.showLoginName = function () {
        baseService.sendGet("/showLoginName").then(function (response) {
                if(response.data) {
                    $scope.loginName = response.data.loginName;
                }
            })
    }
})
