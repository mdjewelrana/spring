'use strict';

app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/use/users/:userId', {userId: '@userId'},
        {
            updateUser: {method: 'PUT'}
        }
        );
    }]);
app.factory('BookList', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/book/booklist/:bookId', {bookId: '@bookId'},
        {
            updateBList: {method: 'PUT'}
        }
        );
    }]);
app.factory('Order', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/ord/order/:orderId', {orderId: '@orderId'},
        {
            updateOrder: {method: 'PUT'}
        }
        );
    }]);

app.controller('OderController', ['$scope', 'Order', 'BookList', 'User', function ($scope, Order, BookList, User) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new Order();
        ob.obj2 = new User();
        ob.obj3 = new BookList();
        ob.fetchAllObject = function () {
            ob.objArray = Order.query();
            $scope.names= ob.objArray2 = User.query();
            $scope.nam= ob.objArray3 = BookList.query();
            
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
            ob.obj = Order.get({orderId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateOrder(function (object) {
                    console.log(object);
                    ob.updatedId = object.orderId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Order.delete({orderId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Order();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Order();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


