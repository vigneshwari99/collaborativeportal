var homeModule = angular.module('homeModule',[]);
app.controller('homeController',['$scope','$http' ,function ($scope,$http) {
    $scope.uploadFiles = function () {

        var request = {
            method: 'POST',
            url: 'http://localhost:8008/demo/addPost',
            data: formdata,
            headers: {
                'Content-Type': undefined
            }
        };

        // SEND THE FILES.
        $http(request)
            .success(function (d) {
                alert(d);
            })
            .error(function () {
            });
    }
    
}]);