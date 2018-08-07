<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="bookController as objCtrl">
            <h1> Book Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Book </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Book for ID: {{ objCtrl.obj.bookReadId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Book Name: </td> <td><input type="text" name="bookNam" ng-model="objCtrl.obj.bookNam" required/> 
                            <span ng-show="objForm.bookNam.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>book url: </td> <td> <input type="text" name="bookPdf" ng-model="objCtrl.obj.bookPdf" required/> 
                            <span ng-show="objForm.bookPdf.$error.required" class="msg-val">bookPdf is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Book successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">book already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Book"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Book"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Book successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Url</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.bookReadId"></span></td>
                    <td><span ng-bind="row.bookNam"></span></td>
                    <td><span ng-bind="row.bookPdf"></span></td>
                    
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.bookReadId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.bookReadId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.bookReadId == objCtrl.updatedId" class="msg-success">Book successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/book_read_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 