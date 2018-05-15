<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
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
    <script src="resources/js/custom/login.js"></script>

    <link href="../resources/css/libs/error.css" rel="stylesheet" type="text/css" media="all"/>
    <title>Error</title>
</head>
<body>
<div class="travolta">
    <h1>${errorMsg}</h1>
    <p>It seems you got lost...</p>

    <a href="#" class="jsGoBack">Go back</a>
</div>

</body>
</html>