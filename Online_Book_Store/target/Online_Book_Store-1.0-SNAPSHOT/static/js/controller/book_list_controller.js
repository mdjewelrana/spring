'use strict';

app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/cat/category/:catId', {catId: '@catId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('SubCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/sub/subcat/:subCatId', {subCatId: '@subCatId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('Author', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/aut/author/:authId', {authId: '@authId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('Publisher', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/pub/publisher/:pubId', {pubId: '@pubId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('BookList', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/Online_Book_Store/book/booklist/:bookId', {bookId: '@bookId'},
                {
                    updateBookList: {method: 'PUT'}
                }
        );
    }]);

app.controller('BookListController', ['$scope', 'BookList', 'Category', 'SubCategory', 'Author', 'Publisher', function ($scope, BookList, Category, SubCategory, Author, Publisher) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.obj = new BookList();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        ob.obj4 = new Author();
        ob.obj5 = new Publisher();
        ob.fetchAllObject = function () {
            ob.objArray = BookList.query();
            $scope.names = ob.objArray2 = Category.query();
            $scope.nams = ob.objArray3 = SubCategory.query();
            $scope.nam = ob.objArray4 = Author.query();
            $scope.na = ob.objArray5 = Publisher.query();
        };
        //$scope.names = ob.objArray2;
        console.log($scope.names + "hello");
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
            ob.obj = BookList.get({bookId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateBookList(function (object) {
                    console.log(object);
                    ob.updatedId = object.bookId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = BookList.delete({bookId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new BookList();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new BookList();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


