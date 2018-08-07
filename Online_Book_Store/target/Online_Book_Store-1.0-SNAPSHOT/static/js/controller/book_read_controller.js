'use strict';

app.factory('BookRead', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/read/readbook/:bookReadId', {bookReadId: '@bookReadId'},
	{
		updateBook: {method: 'PUT'}
	}
    );
}]);

app.controller('bookController', ['$scope', 'BookRead', function($scope, BookRead) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new BookRead(); 
    ob.fetchAllObject = function(){
        ob.objArray = BookRead.query();
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
        ob.obj = BookRead.get({ bookReadId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateBook(function(object){
    		console.log(object); 
		ob.updatedId = object.bookReadId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = BookRead.delete({ bookReadId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new BookRead();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new BookRead();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


