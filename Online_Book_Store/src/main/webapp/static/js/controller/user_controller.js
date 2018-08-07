'use strict';
app.factory('UserRole', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/role/admin/:roleId', {roleId: '@roleId'},
        {
            updateRole: {method: 'PUT'}
        }
        );
    }]);
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/use/users/:userId', {userId: '@userId'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);


app.controller('UserController', ['$scope', 'User', 'UserRole', function($scope, User, UserRole) {
    var ob = this;
    ob.objArray=[];
    ob.objArray2=[];
    ob.user = new User(); 
     ob.user2 = new UserRole();
    ob.fetchAllUser = function(){
        ob.objArray = User.query();
         $scope.names= ob.objArray2 = UserRole.query();
    };
    ob.fetchAllUser();
    ob.addUser = function(){
	console.log('Inside save');
	if($scope.userForm.$valid) {
	  ob.user.$save(function(user){
	     console.log(user); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllUser();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUser = function(id){
	    console.log('Inside edit');
        ob.user = User.get({ userId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateUserDetail = function(){
	console.log('Inside update');
	if($scope.userForm.$valid) {
    	   ob.user.$updateUser(function(user){
    		console.log(user); 
		ob.updatedId = user.userId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllUser();
           });
	}
    };	
    ob.deleteUser = function(id){
	    console.log('Inside delete');
	    ob.user = User.delete({ userId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllUser(); 
	    });
    };		
    ob.reset = function(){
    	ob.user = new User();
        $scope.userForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.user = new User();
	    ob.flag= '';	
   	    ob.fetchAllUser();
    };    
}]); 


