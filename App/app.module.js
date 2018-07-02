var app = angular.module("appName", ['ngCookies','ChatModule','ngRoute','blogModule','loginModule','friendModule','homeModule','forumModule','fileUpload'],function () {
    console.log('Modules added');
    
});

var fileUpload = angular.module('fileUpload',[]);
fileUpload.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);