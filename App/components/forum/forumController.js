var forumModule = angular.module('forumModule', []);
app.controller("forumController", ['$scope', '$http', function ($scope, $http) {
    console.log('sucess');
    $scope.forum = {};
    $scope.addforum = function (product) {

        $scope.forum.imgName = $scope.forum.title + '.jpg';
        $http.post('http://localhost:8008/demo/addForum', $scope.forum).then(
            function (response) {
                console.log(response.data);
                console.log(response.status);
                var fd = new FormData();
                fd.append('file', $scope.image);
                console.log('Image name -> ' + $scope.forum.imgName);

                $http({
                    method: 'POST',
                    url: 'http://localhost:8008/demo/image/upload/' + $scope.forum.imgName,  // The URL to Post.
                    headers: { 'Content-Type': undefined }, // Set the Content-Type to undefined always.
                    data: fd,
                    transformRequest: function (data, headersGetterFunction) {

                        return data;
                    }
                }).then(function (response) {
                    console.log('Image uploaded')
                    $scope.getAllBlogs();
                    $('#modal1').modal('close');
                }, function (error) {

                    console.log('Image was not uploaded');
                    console.log(error);
                });

            },
            function (error) {
                console.log(error);
            });
    }
}]);
