
app.config(function ($routeProvider) {
   
    console.log('Routing started');
    $routeProvider
        .when("/register", {
            templateUrl: "App/components/login/login.html",
            controller: 'LoginController',
            controllerAs: 'loginCtrl'
        })
        .when("/home" || '/', {
            templateUrl: "App/components/home/home.html",
            controller: 'homeController',
            controllerAs: 'homeCtrl'
        })
        .when("/blog/", {
            templateUrl: "App/components/blog/blog.html",
            controller: 'blogController',
            controllerAs: 'blogCtrl'
        })
        .when("/forum", {
            templateUrl: "App/components/forum/forum.html",
            controller: 'forumController',
            controllerAs: 'homeCtrl'
        })
        .when("/friend", {
            templateUrl: "App/components/friend/friend.html",
            controller: 'FriendController',
            controllerAs: 'frndctrl'
        })
});

