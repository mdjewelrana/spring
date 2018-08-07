'use strict';

app.factory('UserRole', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/role/admin/:roleId', {roleId: '@roleId'},
	{
		updateObject: {method: 'PUT'}
	}
    );
}]);


app.controller('AdminController', ['$scope', 'UserRole', function($scope, UserRole) {  
    var ob = this;
    ob.objArray=[];
    ob.obj = new UserRole(); 
    ob.fetchAllObject = function(){
        ob.objArray = UserRole.query();
    };
    ob.fetchAllObject();
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(obj){
	     console.log(obj); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllObject();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editObject = function(id){
	    console.log('Inside edit');
        ob.obj = UserRole.get({ roleId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateObject(function(obj){
    		console.log(obj); 
		ob.updatedId = obj.roleId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = UserRole.delete({ roleId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new UserRole();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new UserRole();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 




