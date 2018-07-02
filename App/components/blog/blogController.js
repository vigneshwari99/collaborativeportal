var blogModule = angular.module('blogModule', []);
app.controller('blogController', ['$scope', '$http', function ($scope, $http) {

  $('.modal').modal();

  console.log('controller called');
  $scope.blog = {};

  $scope.posts = [];
  $scope.image;

  $scope.getAllBlogs = function () {
    try {
      $http.post('http://localhost:8008/demo/getAllPosts').then(
        function (response) {
          console.log('Response generated');
          $scope.posts = response.data;
        }, function (error) {
          console.log(error);
        }
      );
    } catch (error) {
      alert('Opps something went wrong...!');
    }
  }

  $scope.editBlog = function(id){
    $('#modal1').modal('open');
    for(var i= 0 ;i<$scope.posts.length ;i++){
      if($scope.posts[i] == id){
        $scope.blog = $scope.posts[i];
        break;
      }
    }
    console.log('Found -> '+ $scope.blog);
  }

  $scope.getAllBlogs();

  $scope.loader = false;
  $scope.addPost = function () {
    $scope.loader = true;
    $scope.blog.imgName = $scope.blog.title + '.jpg';
    $http.post('http://localhost:8008/demo/addPost', $scope.blog).then(
      function (response) {
        console.log(response.data);
        console.log(response.status);
        var fd = new FormData();
        fd.append('file', $scope.image);

        console.log('Image name -> ' + $scope.blog.imgName);

        $http({
          method: 'POST',
          url: 'http://localhost:8008/demo/image/upload/'+$scope.blog.imgName,  // The URL to Post.
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
