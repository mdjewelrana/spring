'use strict';

app.factory('UpcomingBook', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/upc/upcoming/:bookId', {bookId: '@bookId'},
	{
		updateUpcomingBook: {method: 'PUT'}
	}
    );
}]);

app.controller('UpBookController', ['$scope', 'UpcomingBook', function($scope, UpcomingBook) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new UpcomingBook(); 
    ob.fetchAllObject = function(){
        ob.objArray = UpcomingBook.query();
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
        ob.obj = UpcomingBook.get({ bookId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateUpcomingBook(function(object){
    		console.log(object); 
		ob.updatedId = object.bookId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = UpcomingBook.delete({ bookId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new UpcomingBook();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new UpcomingBook();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


