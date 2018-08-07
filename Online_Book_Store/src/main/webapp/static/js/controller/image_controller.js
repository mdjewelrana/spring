'use strict';

app.factory('BookList', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/book/booklist/:bookId', {bookId: '@bookId'},
        {
            updateBList: {method: 'PUT'}
        }
        );
    }]);
app.factory('Image', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/ima/image/:imageId', {imageId: '@imageId'},
        {
            updateImage: {method: 'PUT'}
        }
        );
    }]);

app.controller('ImageController', ['$scope', 'Image', 'BookList', function ($scope, Image, BookList) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Image();
        ob.obj2 = new BookList();
        ob.fetchAllObject = function () {
            ob.objArray = Image.query();
            $scope.names= ob.objArray2 = BookList.query();
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names+"hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                //ob.obj.tspInfo= ob.obj2;
                ob.obj.$save(function (object) {
                    console.log(object);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Image.get({imageId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateImage(function (object) {
                    console.log(object);
                    ob.updatedId = object.imageId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Image.delete({imageId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Image();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Image();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


var app = angular.module(
  'app', 
  [ 'ngAnimate', 
    'ui.bootstrap',
    'ngResource',
    'ngFileUpload' ]);

app.factory('Model', function($resource) {
  return $resource('api/upload');
});

app.controller('ImageController', function ($scope, Upload, $timeout) {
  $scope.uploadPic = function(file) {
  file.upload = Upload.upload({
    url: 'api/upload/file',
    data: {file: file },
  });
  file.upload.then(function (response) {
    $timeout(function () {
    file.result = response.data;
    });
  }, function (response) {
    if (response.status > 0)
    $scope.errorMsg = "Server Error! ("+response.data+")";
  }, function (evt) {
    // Math.min is to fix IE which reports 200% sometimes
    file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
  });
  }
});




//Test..............................................
//var app = angular.module('plunkr', [])
//  app.controller('UploadController', function($scope, fileReader) {
//    $scope.imageSrc = "";
//    
//    $scope.$on("fileProgress", function(e, progress) {
//      $scope.progress = progress.loaded / progress.total;
//    });
//  });
//
//
//
//
//  app.directive("ngFileSelect", function(fileReader, $timeout) {
//    return {
//      scope: {
//        ngModel: '='
//      },
//      link: function($scope, el) {
//        function getFile(file) {
//          fileReader.readAsDataUrl(file, $scope)
//            .then(function(result) {
//              $timeout(function() {
//                $scope.ngModel = result;
//              });
//            });
//        }
//
//        el.bind("change", function(e) {
//          var file = (e.srcElement || e.target).files[0];
//          getFile(file);
//        });
//      }
//    };
//  });
//
//app.factory("fileReader", function($q, $log) {
//  var onLoad = function(reader, deferred, scope) {
//    return function() {
//      scope.$apply(function() {
//        deferred.resolve(reader.result);
//      });
//    };
//  };
//
//  var onError = function(reader, deferred, scope) {
//    return function() {
//      scope.$apply(function() {
//        deferred.reject(reader.result);
//      });
//    };
//  };
//
//  var onProgress = function(reader, scope) {
//    return function(event) {
//      scope.$broadcast("fileProgress", {
//        total: event.total,
//        loaded: event.loaded
//      });
//    };
//  };
//
//  var getReader = function(deferred, scope) {
//    var reader = new FileReader();
//    reader.onload = onLoad(reader, deferred, scope);
//    reader.onerror = onError(reader, deferred, scope);
//    reader.onprogress = onProgress(reader, scope);
//    return reader;
//  };
//
//  var readAsDataURL = function(file, scope) {
//    var deferred = $q.defer();
//
//    var reader = getReader(deferred, scope);
//    reader.readAsDataURL(file);
//
//    return deferred.promise;
//  };
//
//  return {
//    readAsDataUrl: readAsDataURL
//  };
//});
//(function () {
//    'use strict';
//    var myApp = angular.module('app');
//    myApp.controller('FileUploadController', function ($scope, fileUploadService) {
// 
//        $scope.uploadFile = function () {
//            var file = $scope.myFile;
//            var uploadUrl = "../server/service.php", //Url of webservice/api/server
//                promise = fileUploadService.uploadFileToUrl(file, uploadUrl);
// 
//            promise.then(function (response) {
//                $scope.serverResponse = response;
//            }, function () {
//                $scope.serverResponse = 'An error has occurred';
//            })
//        };
//    });
// 
//})();
angular.module('myApp', ['ngAnimate']);

angular.module('myApp')
.controller('myController', function ($scope) {
  
  $scope.inventory = [
    { id :  1, category : "water bottle", description : "small water bottle",   price :   2.99, qty : 1 },
    { id :  2, category : "water bottle", description : "large water bottle",   price :   2.99, qty : 1, onSale : true },
    { id :  3, category : "flashlight",   description : "small flashlight",     price :   6.99, qty : 1 },
    { id :  4, category : "flashlight",   description : "big flashlight",       price :  12.99, qty : 1 },
    { id :  5, category : "stove",        description : "small stove",          price :  29.99, qty : 1 },
    { id :  6, category : "stove",        description : "big stove",            price :  29.99, qty : 1 },
    { id :  7, category : "sleeping bag", description : "simple sleeping bag",  price :  49.99, qty : 1 },
    { id :  8, category : "sleeping bag", description : "deluxe sleeping bag",  price :  79.99, qty : 1 },
    { id :  9, category : "tent",         description : "1-person tent",        price : 119.99, qty : 1 },
    { id : 10, category : "tent",         description : "2-person tent",        price : 169.99, qty : 1 },
    { id : 11, category : "tent",         description : "3-person tent",        price : 249.99, qty : 1 },
    { id : 12, category : "tent",         description : "4-person tent",        price : 319.99, qty : 1 }
  ];
  
  $scope.cart = [];
  
  var findItemById = function(items, id) {
    return _.find(items, function(item) {
      return item.id === id;
    });
  };
  
  $scope.getCost = function(item) {
    return item.qty * item.price;
  };

  $scope.addItem = function(itemToAdd) {
    var found = findItemById($scope.cart, itemToAdd.id);
    if (found) {
      found.qty += itemToAdd.qty;
    }
    else {
      $scope.cart.push(angular.copy(itemToAdd));}
  };
  
  $scope.getTotal = function() {
    var total =  _.reduce($scope.cart, function(sum, item) {
      return sum + $scope.getCost(item);
    }, 0);
    console.log('total: ' + total);
    return total;
  };
  
  $scope.clearCart = function() {
    $scope.cart.length = 0;
  };
  
  $scope.removeItem = function(item) {
    var index = $scope.cart.indexOf(item);
    $scope.cart.splice(index, 1);
  };
  
});
