<%-- 
    Document   : home
    Created on : Jul 22, 2018, 12:56:06 PM
    Author     : B2
--%>

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



<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css" type="text/css"/>-->
    </head>
    <body>
        <!-- header-section-starts -->
        <div class="header">
            <div class="header-top-strip">
                <div class="container">
                    <div class="header-top-left">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/adm/home"><span class="glyphicon glyphicon-user"> </span>Login</a></li>
                            <li><a href="${pageContext.request.contextPath}/use/home"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li>			
                        </ul>
                    </div>
                    <div class="header-right">
                        <div class="cart box_1">
                            <a href="${pageContext.request.contextPath}/ord/home">
                                <h3> <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>)<img src="${pageContext.request.contextPath}/static/images//bag.png" alt=""></h3>
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
        <div class="banner-top">
            <div class="container">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <div class="logo">
                            <h1><a href="${pageContext.request.contextPath}/book/home"><span>E</span> -Shop</a></h1>
                        </div>
                    </div>
                    <!--/.navbar-header-->

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="index.html">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">All Categories <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>NEW IN</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Clothing</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Bags</a></li>
                                                <li><a href="products.html">New In Shoes</a></li>
                                                <li><a href="products.html">New In Watches</a></li>
                                                <li><a href="products.html">New In Grooming</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-4">
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
                                        </div>
                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>WATCHES</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Analog</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Chronograph</a></li>
                                                <li><a href="products.html">Digital</a></li>
                                                <li><a href="products.html">Watch Cases</a></li>
                                            </ul>
                                        </div>
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
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Clothing</a></li>
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Bags</a></li>
                                                <li><a href="products.html">New In Shoes</a></li>
                                                <li><a href="products.html">New In Watches</a></li>
                                                <li><a href="products.html">New In Beauty</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-4">
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
                                        </div>
                                        <div class="col-sm-4">
                                            <ul class="multi-column-dropdown">
                                                <h6>WATCHES</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Analog</a></li>
                                                <li><a href="products.html">Chronograph</a></li>
                                                <li><a href="products.html">Digital</a></li>
                                                <li><a href="products.html">Watch Cases</a></li>
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
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Boys Clothing</a></li>
                                                <li><a href="products.html">New In Girls Clothing</a></li>
                                                <li><a href="products.html">New In Boys Shoes</a></li>
                                                <li><a href="products.html">New In Girls Shoes</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>ACCESSORIES</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Bags</a></li>
                                                <li><a href="products.html">Watches</a></li>
                                                <li><a href="products.html">Sun Glasses</a></li>
                                                <li><a href="products.html">Jewellery</a></li>
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
                                                <li><a href="${pageContext.request.contextPath}/book/home">New In Boys Clothing</a></li>
                                                <li><a href="products.html">New In Girls Clothing</a></li>
                                                <li><a href="products.html">New In Boys Shoes</a></li>
                                                <li><a href="products.html">New In Girls Shoes</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6">
                                            <ul class="multi-column-dropdown">
                                                <h6>ACCESSORIES</h6>
                                                <li><a href="${pageContext.request.contextPath}/book/home">Bags</a></li>
                                                <li><a href="products.html">Watches</a></li>
                                                <li><a href="products.html">Sun Glasses</a></li>
                                                <li><a href="products.html">Jewellery</a></li>
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
        <div class="banner">
            <div class="container">
                <div class="banner-bottom">
                    <div class="banner-bottom-left">
                        <h2>B<br>U<br>Y</h2>
                    </div>
                    <div class="banner-bottom-right">
                        <div  class="callbacks_container">
                            <ul class="rslides" id="slider4">
                                <li>
                                    <div class="banner-info">
                                        <h3>Search your book</h3>
                                        <p>Start your shopping here...</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="banner-info">
                                        <h3>Book Online</h3>
                                        <p>Start your shopping here...</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="banner-info">
                                        <h3>Pack your Bag</h3>
                                        <p>Start your shopping here...</p>
                                    </div>								
                                </li>
                            </ul>
                        </div>
                        <!--banner-->
                        <script src="js/responsiveslides.min.js"></script>
                        <script>
                            // You can also use "$(window).load(function() {"
                            $(function () {
                                // Slideshow 4
                                $("#slider4").responsiveSlides({
                                    auto: true,
                                    pager: true,
                                    nav: false,
                                    speed: 500,
                                    namespace: "callbacks",
                                    before: function () {
                                        $('.events').append("<li>before event fired.</li>");
                                    },
                                    after: function () {
                                        $('.events').append("<li>after event fired.</li>");
                                    }
                                });

                            });
                        </script>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="shop">
                    <a href="single.html">BOOK COLLECTION NOW</a>
                </div>
            </div>
        </div>
        <!-- content-section-starts-here -->
        <div class="container">
            <div class="main-content">
                <div class="online-strip">
                    <div class="col-md-4 follow-us">
                        <h3>follow us : <a class="twitter" href="#"></a><a class="facebook" href="#"></a></h3>
                    </div>
                    <div class="col-md-4 shipping-grid">
                        <div class="shipping">
                            <img src="${pageContext.request.contextPath}/static/images/shipping.png" alt="" />
                        </div>
                        <div class="shipping-text">
                            <h3>Free Shipping</h3>
                            <p>on orders over $ 199</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="col-md-4 online-order">
                        <p>Order online</p>
                        <h3>Tel:999 4567 8902</h3>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="products-grid">
                    <header>
                        <h3 class="head text-center">Latest Products</h3>
                    </header>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p1.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a1</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$329</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p2.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a2</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$599.8</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p3.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a3</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$359.6</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p4.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a4 </a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$649.99</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p5.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a5</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$750</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p6.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a6</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$295.59</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p7.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a7</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$380</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p8.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a8</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$540.6</span></a></p>
                    </div>
                    <div class="col-md-4 product simpleCart_shelfItem text-center">
                        <a href="single.html"><img src="${pageContext.request.contextPath}/static/images/p9.jpg" alt="" /></a>
                        <div class="mask">
                            <a href="single.html">Quick View</a>
                        </div>
                        <a class="product_name" href="single.html">a9</a>
                        <p><a class="item_add" href="#"><i></i> <span class="item_price">$229.5</span></a></p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

        </div>
        <div class="other-products">
            <div class="container">
                <h3 class="like text-center">Featured Collection</h3>        			
                <ul id="flexiselDemo3">
                    <li><a href="single.html"><img src="${pageContext.request.contextPath}/static/images/l1.jpg" class="img-responsive" alt="" /></a>
                        <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.html">simple</a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price">$759</span></a></p>
                        </div>
                    </li>
                    <li><a href="single.html"><img src="${pageContext.request.contextPath}/static/images/l2.jpg" class="img-responsive" alt="" /></a>						
                        <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.html">simple</a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price">$699</span></a></p>
                        </div>
                    </li>
                    <li><a href="single.html"><img src="${pageContext.request.contextPath}/static/images/l3.jpg" class="img-responsive" alt="" /></a>
                        <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.html">simple</a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
                        </div>
                    </li>
                    <li><a href="single.html"><img src="${pageContext.request.contextPath}/static/images/l4.jpg" class="img-responsive" alt="" /></a>
                        <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.html">simple</a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price">$499</span></a></p>
                        </div>
                    </li>
                    <li><a href="single.html"><img src="${pageContext.request.contextPath}/static/images/l5.jpg" class="img-responsive" alt="" /></a>
                        <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.html">simple</a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price">$649</span></a></p>
                        </div>
                    </li>
                </ul>
                <script type="text/javascript">
                    $(window).load(function () {
                        $("#flexiselDemo3").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint: 480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint: 640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint: 768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
            </div>
        </div>
        <!-- content-section-ends-here -->
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
