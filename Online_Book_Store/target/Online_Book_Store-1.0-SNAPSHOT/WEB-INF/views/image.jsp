

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <script src="${pageContext.request.contextPath}/static/js/controller/sub_category_controller.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/upcoming_book_controller.js"></script>
         <script src="${pageContext.request.contextPath}/static/js/controller/image_controller.js"></script>
    </head>
    <body ng-app="myApp">
        <!-- header-section-starts -->
        <div class="header">
            <div class="header-top-strip">
                <div class="container">
                    <div class="header-top-left">
                        <ul>
                            <li><a href="account.html"><span class="glyphicon glyphicon-user"> </span>Login</a></li>
                            <li><a href="register.html"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li>			
                        </ul>
                    </div>
                    <div class="header-right">
                        <div class="cart box_1">
                            <a href="checkout.html">
                                <h3> <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span> items)<img src="images/bag.png" alt=""></h3>
                            </a>	
                            <p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- header-section-ends -->
        <div class="inner-banner">
            <div class="container">
                <div class="banner-top inner-head">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <div class="logo">
                                <h1><a href="index.html"><span>E</span> -Shop</a></h1>
                            </div>
                        </div>
                        <!--/.navbar-header-->

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="${pageContext.request.contextPath}/aut/home">Index</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">All Categories <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>NEW IN</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Drama</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Poetry</a></li>
                                                <li><a href="products.html">New In Science</a></li>
                                                <li><a href="products.html">New In Children</a></li>
                                                <li><a href="products.html">New In Adult</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>Old</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">History</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Science</a></li>
                                                <li><a href="products.html">Drama</a></li>
                                                <li><a href="products.html">Poetry</a></li>
                                                <li><a href="products.html">Children</a></li>
                                                <li><a href="products.html">Adult</a></li>
                                              
                                            </ul>
                                        </div>
<!--                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>WATCHES</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Analog</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Chronograph</a></li>
                                                <li><a href="products.html">Digital</a></li>
                                                <li><a href="products.html">Watch Cases</a></li>
                                            </ul>
                                        </div>-->
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Kid's <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>NEW IN</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Poetry</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Art</a></li>
                                                <li><a href="products.html">Picture</a></li>
                                                <li><a href="products.html">Comedy</a></li>
                                            
                                            </ul>
                                        </div>
<!--                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>CLOTHING</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Polos & Tees</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Casual Shirts</a></li>
                                                <li><a href="products.html">Casual Trousers</a></li>
                                                <li><a href="products.html">Jeans</a></li>
                                                <li><a href="products.html">Shorts & 3/4th</a></li>
                                                <li><a href="products.html">Formal Shirts</a></li>
                                                <li><a href="products.html">Formal Trousers</a></li>
                                                <li><a href="products.html">Suits & Blazers</a></li>
                                                <li><a href="products.html">Track Wear</a></li>
                                                <li><a href="products.html">Inner Wear</a></li>
                                            </ul>
                                        </div>-->
                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>Cartun</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Animal</a></li>
                                                <li><a href="products.html">poem</a></li>
                                                <li><a href="products.html">history</a></li>
                                          
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Young Adult <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-2">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>NEW IN</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Drama</a></li>
                                                <li><a href="products.html">History</a></li>
                                                <li><a href="products.html">Science</a></li>
                                             
                                            </ul>
                                        </div>
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>Old</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Drama</a></li>
                                                <li><a href="products.html">History</a></li>
                                                <li><a href="products.html"> Science</a></li>
                                                
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Fiction <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-2">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>NEW IN</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Tragedy</a></li>
                                                <li><a href="products.html">New In</a></li>
                                                <li><a href="products.html">New In</a></li>
                                                <li><a href="products.html">New In</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>Old</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">jggjh</a></li>
                                                <li><a href="products.html">jgjhj</a></li>
                                                <li><a href="products.html">hh jhjh</a></li>
                                            
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/book/home">Blog</a></li>
                            
                            <li><a href="contact.html">CONTACT</a></li>
                        </ul>
                    </div>
                        <!--/.navbar-collapse-->
                    </nav>
                    <!--/.navbar-->
                </div>
            </div>
        </div>
        <!-- content-section-starts -->
        <div class="content">
            <div class="container">
                <!--		<div class="login-page">
                                            <div class="dreamcrub">
                                                 <ul class="breadcrumbs">
                                    <li class="home">
                                       <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                                       <span>&gt;</span>
                                    </li>
                                    <li class="women">
                                       Login
                                    </li>
                                </ul>
                                <ul class="previous">
                                        <li><a href="index.html">Back to Previous Page</a></li>
                                </ul>
                                <div class="clearfix"></div>
                                           </div>
                                           <div class="account_grid">
                                           <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
                                                 <h2>NEW CUSTOMERS</h2>
                                                 <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                                                 <a class="acount-btn" href="register.html">Create an Account</a>
                                           </div>
                                           <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                                                <h3>REGISTERED CUSTOMERS</h3>
                                                <p>If you have an account with us, please log in.</p>-->
                .
                   <div ng-controller="ImageController as objCtrl">
            <h1> Image Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Image </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Image for ID: {{ objCtrl.obj.imageId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Book Title</td>
                        <td>
                            <select ng-model="objCtrl.obj.bookList" ng-options="x.bookTitle for x in names">
</select>
                        </td>
                    </tr>
                    <tr>
                        <td>Image Name: </td> <td><input type="text" name="imageName" ng-model="objCtrl.obj.imageName" required/> 
                            <span ng-show="objForm.imageName.$error.required" class="msg-val">Image Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Image: </td> <td><input type="file" ng-file-select="onFileSelect($files)" name="image" ng-model="objCtrl.obj.image" required/> 
                            <span ng-show="objForm.image.$error.required" class="msg-val">Image is required.</span> </td>
                    </tr>
                    
                     <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Image successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Image already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Image"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Image"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Image successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>Book Title</th> 
                    <th>Image Name</th> 
                    <th>Image</th>
                    
                    
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.imageId"></span></td>
                    <td><span ng-bind="row.bookList.bookTitle"></span></td>
                    <td><span ng-bind="row.imageName"></span></td>
                    <td><img ng-src=row.image"></td>
                 
                   
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.imageId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.imageId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.imageId == objCtrl.updatedId" class="msg-success">Image successfully updated.</span> </td> 
                </tr>	
<!--                <tr ng-repeat="row in objCtrl.objArray2">
                    <td><span ng-bind="row.tspName"></span></td>
                    
                </tr>-->
            </table>
        </div>

                <a class="forgot" href="#">Forgot Your Password?</a>
                <input type="submit" value="Login">

            </div>	
            <div class="clearfix"> </div>
            <!--			 </div>
                               </div>
            </div>-->
            <div class="news-letter">
                <div class="container">
                    <div class="join">
                        <h6>JOIN OUR MAILING LIST</h6>
                        <div class="sub-left-right">
                            <form>
                                <input type="text" value="Enter Your Email Here" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Enter Your Email Here';
                                        }" />
                                <input type="submit" value="SUBSCRIBE" />
                            </form>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="container">
                <div class="footer_top">
                    <div class="span_of_4">
                        <div class="col-md-3 span1_of_4">
                            <h4>Popular Categories</h4>
                            <ul class="f_nav">
                                <li><a href="#">children's</a></li>
                                <li><a href="#">teen and young adult</a></li>
                                <li><a href="#">romance</a></li>
                                <li><a href="#">literature & fiction</a></li>
                               
                            </ul>	
                        </div>
                        <div class="col-md-3 span1_of_4">
                            <h4>quick help</h4>
                            <ul class="f_nav">
                                <li><a href="#">help and support</a></li>
                                <li><a href="#">billing</a></li>
                                <li><a href="#">return policy</a></li>
                                <li><a href="#">contact us</a></li>
                                
                            </ul>	
                        </div>
                        <div class="col-md-3 span1_of_4">
                            <h4>my account</h4>
                            <ul class="f_nav">
                                <li><a href="account.html">Setting</a></li>
                                <li><a href="register.html">Shopping cart</a></li>
                                <li><a href="#">order history</a></li>
                                
                            </ul>				
                        </div>
                        <div class="col-md-3 span1_of_4">
                            <h4>information</h4>
                            <ul class="f_nav">
                                <li><a href="#">Shipping Costs</a></li>
                                <li><a href="#">about book store</a></li>
                                
                            </ul>			
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="cards text-center">
                    <img src="${pageContext.request.contextPath}/static/images/cards.jpg" alt="" />
                </div>
                <div class="copyright text-center">
                    <p>© 2018 E-Shop. All Rights Reserved | Design by   <a href="">JR-34</a></p>
                </div>
            </div>
        </div>
    </body>
</html>
<!--<div ng-app="plunkr">
<div ng-controller="UploadController ">
    <form>
      <input type="file" ng-file-select="onFileSelect($files)" ng-model="imageSrc">
       
    </form>
    
    <img ng-src="{{imageSrc}}" />
      
  </div>
</div>-->