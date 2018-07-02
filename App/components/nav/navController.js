
app.controller('navController',['$rootScope','$cookieStore',function($rootScope,$cookieStore){
    
    $("#side-chat").sideNav();
    $rootScope.currentUser = '';

    try {
        $rootScope.currentUser = $cookieStore.get('currentUser');
    } catch (error) {
        $rootScope.currentUser = '';
        console.log('No user is logged in');
    }

    $rootScope.logout = function(){
        $cookieStore.put('currentUser','');
        $rootScope.currentUser = '';
    }
    
}]);