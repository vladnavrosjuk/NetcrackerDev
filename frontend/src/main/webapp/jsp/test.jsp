<script src="resources/js/libs/jquery-3.2.1.min.js"></script>

<script src="resources/js/libs/packaged.min.js"></script>

<script src="resources/js/libs/popper.min.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>
<script src="resources/js/libs/bootstrap-table.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="resources/css/general.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="../../resources/js/libs/bootstrap-multiselect.js"></script>
<link href="../../resources/css/libs/bootstrap-multiselect.css" rel="stylesheet" type="text/css" media="all"/>
<script src="../resources/js/libs/jquery.inputmask.bundle.js" ></script>
<script src="resources/js/custom/login.js"></script>




<link href="../resources/css/test.css" rel="stylesheet" type="text/css" media="all"/>

<section class="login-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 login-sec">
                <h2 class="text-center">Login Now</h2>


                        <label for="exampleInputEmail1" class="text-uppercase">Username</label>
                        <input type="text" class="form-control  jsInputNameAutor" id="exampleInputEmail1" placeholder="">



                        <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                        <input type="password" id="exampleInputPassword1" class="form-control jsInputPassword" placeholder="">



                        <br>
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input">
                            <small>Remember Me</small>
                        </label>
                        <button type="submit" class="btn btn-login float-right jsButtonAutor">Submit</button>
                <button type="submit" data-toggle="modal" data-target="#register" class="btn btn-login float-right jsButtonReg">Registr</button>



                <div class="copy-text">Created with <i class="fa fa-heart"></i> by <a href="https://github.com/vladnavrosjuk">VladNavrosjuk</a></div>
            </div>
            <div class="col-md-8 banner-sec">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="/resources/css/images/1.JPG" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="banner-text">

                                    <h2>Global Observation</h2>
                                    <p>Opportunity for information on students and practitioners</p>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="/resources/css/images/2.JPG" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="banner-text">
                                    <h2>Flexible editing</h2>
                                    <p>A lot of editing, deleting and creating.</p>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="/resources/css/images/3.JPG" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="banner-text">
                                    <br>
                                    <h2>Different roles - different possibilities</h2>
                                    <p>Each user receives information in accordance with their status</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>


<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center" id="isReleaseStudent">idReleaseStudent</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">





            </div>
        </div>
    </div>
</div>