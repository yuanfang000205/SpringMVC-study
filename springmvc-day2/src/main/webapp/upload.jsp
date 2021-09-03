<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试文件上传</title>
</head>
<body>

    <h1>文件上传</h1>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">

        <input type="file" name="img"/>

        <input type="submit" value="上传文件">

    </form>

    <h1>文件下载</h1>
    <ul>
        <li>test.txt <a href="${pageContext.request.contextPath}/file/down?fileName=test.txt">在线打开</a> <a href="${pageContext.request.contextPath}/file/down?fileName=test.txt&openStyle=attch">附件下载</a></li>
        <li>test.png<a href="${pageContext.request.contextPath}/file/down?fileName=test.png">在线打开</a> <a href="${pageContext.request.contextPath}/file/down?fileName=test.png&openStyle=attch">附件下载</a></li>
        <li>测试.txt <a href="${pageContext.request.contextPath}/file/down?fileName=测试.txt">在线打开</a> <a href="${pageContext.request.contextPath}/file/down?fileName=测试.txt&openStyle=attch">附件下载</a></li>
    </ul>




</body>
</html>