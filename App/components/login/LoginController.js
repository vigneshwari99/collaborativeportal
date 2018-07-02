var app = angular.module('loginModule', []);
app.controller('LoginController', ['$scope', '$http', '$rootScope', '$location', '$cookieStore',
    function ($scope, $http, $rootScope, $location, $cookieStore) {

        $scope.loader = false;
        $scope.user = {};
        $scope.register = {};
        console.log('Login service reached...!!!');
        $scope.test = function () {
            $scope.loader = true;
            if ($scope.user.email != '' || $scope.user.email != null || $scope.user.email != undefined) {
                $http.post('http://localhost:8008/demo/test', $scope.user).then(function (response) {
                    console.log(response.data);
                    console.log(response.status);
                    console.log($scope.username)

                    $cookieStore.put('currentUser', response.data);
                    $rootScope.currentUser = response.data;

                    $scope.user = {};
                    $scope.loader = false;
                    $('#login-modal').modal('close');
                    $location.path("/home");
                },
                    function (error) {
                        console.log(error);
                        $scope.loader = false;
                    })
            } else {
                Materialize.toast('E-Mail Cannot be empty', 4000);
                $scope.loader = false;
            }
        };
        $scope.regact = function () {
            $scope.loader = true;
            if ($scope.register.email != '' || $scope.register.email != null || $scope.register.email != undefined) {
                $http.post('http://localhost:8008/demo/regact', $scope.register).then(function (response) {
                    console.log(response.data);
                    $scope.loader = false;
                },
                    function (error) {
                        console.log(error);
                        $scope.loader = false;
                    })
            } else {
                Materialize.toast('E-Mail Cannot be empty', 4000);
                $scope.loader = false;
            }
        };
    }]);

