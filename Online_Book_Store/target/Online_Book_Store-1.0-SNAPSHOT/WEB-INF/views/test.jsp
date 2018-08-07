<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <title>
        Test
    </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css" type="text/css"/>
        <script src="${pageContext.request.contextPath}/static/js/lib/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/bootstrap-3.1.1.min.js"></script>

        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>



        <script src="${pageContext.request.contextPath}/static/js/lib/cbpViewModeSwitch.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/responsive-tabs.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/simpleCart.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/responsiveslides.min.js"></script>

        <script src="${pageContext.request.contextPath}/static/js/lib/jquery.flexslider.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/imagezoom.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/classie.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/jquery.flexisel.js"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/component.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/flexslider.css" type="text/css"/>
        
         <script src="${pageContext.request.contextPath}/static/js/controller/image_controller.js"></script>
         <style type="text/css">
          
                body {
  margin: 20px;
  padding: 20px 40px;
  font-family: "Verdana";
}

h1 {
  text-align: center;
}

h4 {
  text-align: center;
}

.table {
  width: 600px;
}

.on-sale {
  color: red;
}

.qty {
  width: 60px;
}

.animate-repeat2 {
  line-height:40px;
  list-style:none;
  box-sizing:border-box;
}

.animate-repeat2.ng-move,
.animate-repeat2.ng-enter,
.animate-repeat2.ng-leave {
  -webkit-transition:all linear 0.5s;
  transition:all linear 0.5s;
}

.animate-repeat2.ng-leave.ng-leave-active,
.animate-repeat2.ng-move,
.animate-repeat2.ng-enter {
  opacity:0;
  max-height:0;
}

.animate-repeat2.ng-leave,
.animate-repeat2.ng-move.ng-move-active,
.animate-repeat2.ng-enter.ng-enter-active {
  opacity:1;
  max-height:40px;
}
        </style>
</head>
     <body class="container" ng-controller="myController">
    <h1>Welcome to the GA Camping Store</h1>
    <br/>
    <h4>Filtering input: <input type="text" ng-model="searchText"></h4>
    <br/>
    <div class="row">
      <table class="table col-md-9 col-md-offset-3">
        <tr>
          <th>Category</th>
          <th>Description</th>
          <th>Price</th>
          <th class="qty">Qty</th>
          <th>Total</th>
        </tr>
        <tr class="animate-repeat" ng-repeat="item in inventory | filter:searchText | orderBy:'category' ">
          <td>{{ item.category }}</td>
          <td>{{ item.description }}</td>
          <td ng-class="{ 'on-sale' : item.onSale }">{{ item.price | currency }}</td>
          <td><input type="number" ng-model="item.qty" class="qty"></td>
          <td>{{ item.qty * item.price | currency }}</td>
          <td>
            <button class="btn-primary" ng-click="addItem(item)">Add to Cart</button></td>
        </tr>
      </table>
    </div>
    <div class="row">
      <h2>Your Cart:</h2>
      <ul>
        <li class="animate-repeat" ng-repeat="item in cart | orderBy:'category'">
          <span>{{ item.qty + ' x ' + item.description + ' = ' + (getCost(item) | currency) }}</span>
          <button class="btn-danger btn-xs" ng-click="removeItem(item);">Remove Item</button>
          </br>
          </br>
        </li>
      </ul>
      <h3>Total: {{ getTotal() | currency }}</h3>
      <button class="btn-danger" ng-click="clearCart();">Clear Cart</button>
    </div>
  </body>    
<!--         
           <div class="container">

             PICTURE FILE 

            <form name="objForm" ng-controller="ImageController">
                <h1>Picture</h1>
                <p>Upload Picture on form submit, Alerts</p>
                 BROWSE 
                <div class="form-group">
                    <input type="file" 
                           ngf-select 
                           ng-model="picFile" name="file"    
                           accept="image/*" 
                           ngf-max-size="2MB"
                           required>
                    <i ng-show="objForm.file.$error.maxSize">File too large {{picFile.size / 1000000|number:1}}MB: max 2M</i>
                </div>
                 PREVIEW 
                <div class="form-group">
                    <img class="thumb"
                         ng-show="objForm.file.$valid" 
                         ngf-thumbnail="picFile">
                    <button class="btn btn-danger btn-xs" 
                            ng-click="picFile = null" 
                            ng-show="picFile">
                        <i class="glyphicon glyphicon-remove"></i> Remove
                    </button>
                </div>
                 SUBMIT 
                <button class="btn btn-success" 
                        ng-disabled="!objForm.$valid" 
                        ng-click="uploadPic(picFile)">
                    <i class="glyphicon glyphicon-ok"></i> Submit
                </button>
                 ALERT 
                <p>
                <div class="alert alert-danger" ng-show="errorMsg">Upload Error!</div>
                <div class="alert alert-success" ng-show="picFile.result">Upload Successful.</div>
                
            </form>
         
         
         
         
         <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/angular.js"></script>
         <script type="text/javascript">
   
    

//var app = angular.module("myApp",[]);
//app.controller("myCtrl",function($scope,$http){
//$http.get("images/p1.jpg")
//        .then(function(response){
//            $scope.p1 = response.data;
//        });
//});
//</script>
 </head>
 <body>
     <h4>jjjjjj</h4>
     <div ng-controller="//myCtrl"></div>
     <table border="1">
         <tr>
             <th>title</th>
             <th>image</th>
             <th>url</th>
         </tr>
         <tr ng-repeat="//friend in p1">
             <td>{{//friend}}</td>
             <td>{{//friend}}</td>
             <td><images ng-src="{{//friend}}"></td>
         </tr>
     </table>

       
       
       
       
       
       
       
<!--<div ng-app="plunkr">
<div ng-controller="UploadController ">
    <form>
      <input type="file" ng-file-select="onFileSelect($files)" ng-model="imageSrc">
        <input type="file" ng-file-select="onFileSelect($files)" multiple> 
    </form>
    
    <img ng-src="{{imageSrc}}" />
      
  </div>
</div>
      </body>-->
 </html>