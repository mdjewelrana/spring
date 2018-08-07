'use strict';

app.factory('Author', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/aut/author/:authId', {authId: '@authId'},
	{
		updateObject: {method: 'PUT'}
	}
    );
}]);


app.controller('AuthorController', ['$scope', 'Author', function($scope, Author) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new Author(); 
    ob.fetchAllObject = function(){
        ob.objArray = Author.query();
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
        ob.obj = Author.get({ authId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateObject(function(obj){
    		console.log(obj); 
		ob.updatedId = obj.authId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = Author.delete({ authId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new Author();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new Author();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 




