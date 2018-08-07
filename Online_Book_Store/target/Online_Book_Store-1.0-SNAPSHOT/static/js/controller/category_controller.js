'use strict';

app.factory('Category', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/cat/category/:catId', {catId: '@catId'},
	{
		updateCategory: {method: 'PUT'}
	}
    );
}]);

app.controller('CategoryController', ['$scope', 'Category', function($scope, Category) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new Category(); 
    ob.fetchAllObject = function(){
        ob.objArray = Category.query();
    };
    ob.fetchAllObject();
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(object){
	     console.log(object); 
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
        ob.obj = Category.get({ catId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateCategory(function(object){
    		console.log(object); 
		ob.updatedId = object.catId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = Category.delete({ catId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new Category();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new Category();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


