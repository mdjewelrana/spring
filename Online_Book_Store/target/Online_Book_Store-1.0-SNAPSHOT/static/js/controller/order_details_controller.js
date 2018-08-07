'use strict';

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
            updateObject: {method: 'PUT'}
        }
        );
    }]);
app.factory('OrderDetails', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/ode/odetails/:orderDetailId', {orderDetailId: '@orderDetailId'},
        {
            updateOrderDetails: {method: 'PUT'}
        }
        );
    }]);

app.controller('OdetailController', ['$scope', 'OrderDetails', 'BookList', 'Order', function ($scope, OrderDetails, BookList, Order) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new OrderDetails();
        ob.obj2 = new BookList();
        ob.obj3 = new Order();
        ob.fetchAllObject = function () {
            ob.objArray = OrderDetails.query();
            $scope.names= ob.objArray2 = BookList.query();
            $scope.nams= ob.objArray3 = Order.query();
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
            ob.obj = OrderDetails.get({orderDetailId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateOrderDetails(function (object) {
                    console.log(object);
                    ob.updatedId = object.orderDetailId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = OrderDetails.delete({orderDetailId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new OrderDetails();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new OrderDetails();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


