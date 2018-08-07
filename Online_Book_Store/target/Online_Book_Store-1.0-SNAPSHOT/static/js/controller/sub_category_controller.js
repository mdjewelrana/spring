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
            updateScategory: {method: 'PUT'}
        }
        );
    }]);

app.controller('SubCatController', ['$scope', 'SubCategory', 'Category', function ($scope, SubCategory, Category) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new SubCategory();
        ob.obj2 = new Category();
        ob.fetchAllObject = function () {
            ob.objArray = SubCategory.query();
            $scope.names= ob.objArray2 = Category.query();
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
            ob.obj = SubCategory.get({subCatId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateScategory(function (object) {
                    console.log(object);
                    ob.updatedId = object.subCatId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = SubCategory.delete({subCatId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new SubCategory();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new SubCategory();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


