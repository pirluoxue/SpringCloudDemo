<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>404错误页</title>
</head>
<body>

<h1>走错路咯~ ~(>^ω^<)喵</h1>
<#--<script type="text/javascript" src="http://localhost:9020/static/js/jquery-3.2.1.js"></script>-->
<#--<script type="text/javascript" src="${acp.contextPath}/static/js/jquery-3.2.1.js"></script>-->
<script type="text/javascript" src="${static_server}/static/js/jquery-3.2.1.js"></script>
<script>
    console.log("${acp.locale}");
    $.post("http://localhost:9035/SPRING-CLOUD-CONSUMER/freemarkerTestFeign",function (res) {
    // $.post("http://localhost:9010/product",function (res) {
        const div = document.createElement('divform');
        div.innerHTML = res;
        document.body.appendChild(div);
    });
</script>
</body>
</html>