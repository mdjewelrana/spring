'use strict';

app.factory('Publisher', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Online_Book_Store/pub/publisher/:pubId', {pubId: '@pubId'},
	{
		updatePublisher: {method: 'PUT'}
	}
    );
}]);

app.controller('PublisherController', ['$scope', 'Publisher', function($scope, Publisher) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new Publisher(); 
    ob.fetchAllObject = function(){
        ob.objArray = Publisher.query();
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
        ob.obj = Publisher.get({ pubId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updatePublisher(function(obj){
    		console.log(obj); 
		ob.updatedId = obj.pubId;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = Publisher.delete({ pubId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new Publisher();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new Publisher();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


